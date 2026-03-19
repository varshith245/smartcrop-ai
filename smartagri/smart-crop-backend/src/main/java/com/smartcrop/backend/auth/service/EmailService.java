package com.smartcrop.backend.auth.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String fromEmail;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendOtpEmail(String toEmail, String otp) {

        try {

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("SmartCrop <" + fromEmail + ">");
            helper.setTo(toEmail);
            helper.setSubject("SmartCrop OTP Verification 🌱");

            String htmlContent =
                    "<h2>SmartCrop OTP Verification</h2>" +
                    "<p>Your OTP is:</p>" +
                    "<h1 style='color:green'>" + otp + "</h1>" +
                    "<p>This OTP is valid for 5 minutes.</p>";

            helper.setText(htmlContent, true);

            mailSender.send(message);

            System.out.println("OTP Email Sent Successfully");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Email sending failed");
        }
    }
}
