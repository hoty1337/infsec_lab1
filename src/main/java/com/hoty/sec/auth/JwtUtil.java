package com.hoty.sec.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.MacAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final JwtKeyProvider keyProvider;

    private final MacAlgorithm alg = Jwts.SIG.HS256;

    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + 3600_000);

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(keyProvider.getKey(), alg)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(keyProvider.getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
