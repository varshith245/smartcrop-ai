package com.smartcrop.backend.config;

import com.smartcrop.backend.user.entity.User;
import com.smartcrop.backend.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminInitializer {

    @Bean
    CommandLineRunner createAdmin(UserRepository userRepository,
                                  PasswordEncoder passwordEncoder) {

        return args -> {

            if (userRepository.findByEmail("admin@smartcrop.com").isEmpty()) {

                User admin = new User();
                admin.setName("System Admin");
                admin.setEmail("admin@smartcrop.com");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole(User.Role.ADMIN);
                admin.setStatus(User.Status.ACTIVE);

                userRepository.save(admin);

                System.out.println("✅ Default admin created: admin@smartcrop.com / admin123");
            }
        };
    }
}
