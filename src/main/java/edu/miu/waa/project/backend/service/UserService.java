package edu.miu.waa.project.backend.service;

import edu.miu.waa.project.backend.domain.dto.request.UserRequestDto;
import edu.miu.waa.project.backend.domain.dto.response.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    UserResponseDto findById(long userId);

    UserRequestDto getLoggedInUser();

    Boolean isAdmin();

}
