package com.smartcrop.backend.user.controller;

import com.smartcrop.backend.user.entity.User;
import com.smartcrop.backend.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // =========================
    // GET USER BY ID
    // =========================
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // =========================
    // GET USER BY EMAIL
    // =========================
    @GetMapping("/email")
    public User getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    // =========================
    // GET ALL USERS
    // =========================
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // =========================
    // DELETE USER BY ID
    // =========================
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "User deleted successfully";
    }

    // =========================
    // ACTIVATE USER (ADMIN)
    // =========================
    @PutMapping("/{id}/activate")
    public String activateUser(@PathVariable Long id) {
        userService.activateUser(id);
        return "User activated successfully";
    }

    // =========================
    // DEACTIVATE USER (ADMIN)
    // =========================
    @PutMapping("/{id}/deactivate")
    public String deactivateUser(@PathVariable Long id) {
        userService.deactivateUser(id);
        return "User deactivated successfully";
    }
}
