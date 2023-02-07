package edu.miu.waa.project.backend.controller;

import edu.miu.waa.project.backend.domain.dto.LoginRequest;
import edu.miu.waa.project.backend.domain.dto.LoginResponse;
import edu.miu.waa.project.backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/authenticate")
public class AuthController {
    private final AuthService authService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }


}
