package com.hoty.sec.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    @Pattern(
            regexp = "^[A-Za-z0-9._-]+$",
            message = "Username may contain letters, digits, ., - and _"
    )
    private String username;

    @NotBlank
    @Size(min = 6, max = 100)
    private String password;
}
