package com.smartcrop.backend.auth.service;

import com.smartcrop.backend.auth.dto.*;
import com.smartcrop.backend.user.entity.User;
import com.smartcrop.backend.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmailService emailService;
    private final TokenService tokenService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       EmailService emailService,
                       TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.emailService = emailService;
        this.tokenService = tokenService;
    }

    public String register(RegisterRequest request) {

    User user = userRepository.findByEmail(request.getEmail()).orElse(null);

    // CASE 1 → Already active
    if (user != null && user.getStatus() == User.Status.ACTIVE) {
        throw new RuntimeException("Email already registered. Please login.");
    }

    // CASE 2 → Pending user → resend OTP
    if (user != null && user.getStatus() == User.Status.PENDING) {

        String otp = generateOtp();
        user.setOtp(otp);

        userRepository.save(user);
        emailService.sendOtpEmail(user.getEmail(), otp);

        return "OTP resent to your email.";
    }

    // CASE 3 → New user
    user = new User();
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setRole(User.Role.valueOf(request.getRole().toUpperCase()));
    user.setStatus(User.Status.PENDING);

    String otp = generateOtp();
    user.setOtp(otp);

    userRepository.save(user);
    emailService.sendOtpEmail(user.getEmail(), otp);

    return "OTP sent to your email.";
}


    public void verifyOtp(String email, String otp) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!otp.equals(user.getOtp())) {
            throw new RuntimeException("Invalid OTP");
        }

        user.setStatus(User.Status.ACTIVE);
        user.setOtp(null);
        userRepository.save(user);
    }

    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (user.getStatus() != User.Status.ACTIVE) {
            throw new RuntimeException("Account not verified");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = tokenService.generateToken(
             String.valueOf(user.getId()), 
        //user.getEmail(),
        user.getRole().name()
);

        return new AuthResponse(
        token,
        user.getEmail(),
        user.getRole().name(),
        user.getId()
);
    }

    private String generateOtp() {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }
}
