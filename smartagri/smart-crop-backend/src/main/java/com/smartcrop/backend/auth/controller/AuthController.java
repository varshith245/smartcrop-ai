package com.smartcrop.backend.auth.controller;

import com.smartcrop.backend.auth.dto.*;
import com.smartcrop.backend.auth.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/verify-otp")
public String verifyOtp(@RequestBody VerifyOtpRequest request) {

    authService.verifyOtp(request.getEmail(), request.getOtp());

    return "Account activated successfully";
}

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
