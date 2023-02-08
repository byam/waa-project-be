package edu.miu.waa.project.backend.service;

import edu.miu.waa.project.backend.domain.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

    UserDto getLoggedInUser();

    Boolean isAdmin();
}
