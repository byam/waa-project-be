package edu.miu.waa.project.backend.service.impl;

import edu.miu.waa.project.backend.domain.dto.LoginRequest;
import edu.miu.waa.project.backend.domain.dto.LoginResponse;
import edu.miu.waa.project.backend.service.AuthService;
import edu.miu.waa.project.backend.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {

            Authentication result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
            final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());

            final String accessToken = jwtUtil.generateToken(userDetails);

            final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
            var loginResponse = new LoginResponse(accessToken, refreshToken);
            return loginResponse;
        } catch (BadCredentialsException e) {
            System.out.println("ISSUE" + e.getMessage());
            throw new BadCredentialsException(e.getMessage());
        }


    }
}
