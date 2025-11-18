package com.hoty.sec.auth;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Getter
@Component
public class JwtKeyProvider {

    private final SecretKey key;

    public JwtKeyProvider(@Value("${jwt.secret:dev-secret-change-me-12345678901234567890}") String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }
}
