package com.smartcrop.backend.user.service;

import com.smartcrop.backend.user.entity.User;
import com.smartcrop.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // =========================
    // GET USER BY ID
    // =========================
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // =========================
    // GET USER BY EMAIL
    // =========================
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    // =========================
    // GET ALL USERS
    // =========================
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // =========================
    // DELETE USER BY ID
    // =========================
    public void deleteUserById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    // =========================
    // ACTIVATE USER (ADMIN USE)
    // =========================
    public void activateUser(Long id) {
        User user = getUserById(id);
        user.setStatus(User.Status.ACTIVE);
        userRepository.save(user);
    }

    // =========================
    // DEACTIVATE USER (ADMIN USE)
    // =========================
    public void deactivateUser(Long id) {
        User user = getUserById(id);
        user.setStatus(User.Status.PENDING);
        userRepository.save(user);
    }
}
