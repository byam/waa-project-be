package edu.miu.waa.project.backend.service;

import edu.miu.waa.project.backend.domain.dto.request.LoginRequest;
import edu.miu.waa.project.backend.domain.dto.request.RegisterRequest;
import edu.miu.waa.project.backend.domain.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);

    void register(RegisterRequest registerRequest);
}
