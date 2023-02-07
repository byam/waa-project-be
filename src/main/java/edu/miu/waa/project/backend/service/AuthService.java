package edu.miu.waa.project.backend.service;

import edu.miu.waa.project.backend.domain.dto.LoginRequest;
import edu.miu.waa.project.backend.domain.dto.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
}
