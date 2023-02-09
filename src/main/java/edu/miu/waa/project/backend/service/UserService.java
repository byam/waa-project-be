package edu.miu.waa.project.backend.service;

import edu.miu.waa.project.backend.domain.dto.request.UserRequestDto;
import edu.miu.waa.project.backend.domain.dto.response.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {

    UserResponseDto findById(long userId);

    List<UserResponseDto> findAll();

    UserRequestDto getLoggedInUser();

    Boolean isAdmin();

    Boolean isOwner();

    Boolean isCustomer();

}
