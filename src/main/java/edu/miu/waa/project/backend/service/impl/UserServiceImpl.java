package edu.miu.waa.project.backend.service.impl;

import edu.miu.waa.project.backend.domain.User;
import edu.miu.waa.project.backend.domain.dto.UserDto;
import edu.miu.waa.project.backend.enumSet.RoleType;
import edu.miu.waa.project.backend.repo.UserRepo;
import edu.miu.waa.project.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User with username - %s not found", username)));

    }

    @Override
    public UserDto getLoggedInUser() {
        try {
            User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return modelMapper.map(loggedInUser, UserDto.class);

        } catch (Exception e) {
            System.out.println("No Logged in User");
            return null;
        }

    }

    @Override
    public Boolean isAdmin() {
        return userRepo.findById(getLoggedInUser().getId()).get().getRoles().stream().anyMatch(u -> u.getRole() == RoleType.ADMIN);
    }
}
