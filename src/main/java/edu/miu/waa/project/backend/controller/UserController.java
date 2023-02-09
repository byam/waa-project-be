package edu.miu.waa.project.backend.controller;


import edu.miu.waa.project.backend.domain.dto.response.UserResponseDto;
import edu.miu.waa.project.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseDto> findAll() {
       return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }
}
