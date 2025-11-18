package com.hoty.sec.controller;

import com.hoty.sec.auth.AuthService;
import com.hoty.sec.dto.LoginRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public TokenResponse login(@RequestBody LoginRequest request) {
        String token = authService.login(
                request.getUsername(),
                request.getPassword()
        );
        return new TokenResponse(token);
    }

    @PostMapping("/register")
    public TokenResponse register(@Valid @RequestBody LoginRequest request) {
        String token = authService.register(
                request.getUsername(),
                request.getPassword()
        );
        return new TokenResponse(token);
    }

    public record TokenResponse(String token) {}
}
