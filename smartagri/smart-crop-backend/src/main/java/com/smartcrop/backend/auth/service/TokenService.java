package com.smartcrop.backend.auth.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class TokenService {

    private static final String SECRET =
            "SMART_CROP_JWT_SECRET_KEY_12345678901234567890";

    public String generateToken(String email, String role) {

    return Jwts.builder()

            .setSubject(email)

            // ✅ ADD ROLE CLAIM
            .claim("role", role)

            .setIssuedAt(new Date())

            .setExpiration(
                new Date(System.currentTimeMillis() + 86400000)
            )

            .signWith(
                Keys.hmacShaKeyFor(
                    SECRET.getBytes(StandardCharsets.UTF_8)
                ),
                SignatureAlgorithm.HS256
            )

            .compact();
}
}
