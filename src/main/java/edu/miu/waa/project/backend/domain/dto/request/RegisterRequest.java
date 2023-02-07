package edu.miu.waa.project.backend.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Email is Required")
    private String email;

    @NotBlank(message = "Password is missing")

    private String password;

    @NotBlank(message = "isOwner property is Required")

    private Boolean isOwner;
}
