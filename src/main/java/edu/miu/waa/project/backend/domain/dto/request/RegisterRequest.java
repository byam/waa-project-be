package edu.miu.waa.project.backend.domain.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;

    private String password;

    private Boolean isOwner;
}
