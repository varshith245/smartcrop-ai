package com.smartcrop.backend.admin.controller;

import com.smartcrop.backend.admin.dto.DashboardStats;
import com.smartcrop.backend.admin.service.AdminService;

import com.smartcrop.backend.user.entity.User;
import com.smartcrop.backend.user.entity.User.Status;
import com.smartcrop.backend.user.repository.UserRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService service;
    private final UserRepository userRepo;

    public AdminController(
            AdminService service,
            UserRepository userRepo
    ) {
        this.service = service;
        this.userRepo = userRepo;
    }

    // 📊 Dashboard
    @GetMapping("/dashboard")
    public DashboardStats dashboard() {
        return service.getStats();
    }

    // 👨‍🌾 All Farmers / Users
    @GetMapping("/users")
    public List<User> allUsers() {
        return userRepo.findAll();
    }

    // ❌ Deactivate User
   @PutMapping("/users/{id}/deactivate")
public String deactivate(@PathVariable Long id) {

    User user = userRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    user.setStatus(Status.BLOCKED);

    userRepo.save(user);

    return "User deactivated";
}
@PutMapping("/users/{id}/activate")
public String activate(@PathVariable Long id) {

    User user = userRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    user.setStatus(User.Status.ACTIVE);

    userRepo.save(user);

    return "User activated";
}

@DeleteMapping("/users/{id}")
public String deleteUser(@PathVariable Long id) {

    User user = userRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    userRepo.delete(user);

    return "User deleted successfully";
}
@GetMapping("/farmers")
public List<User> getFarmers() {
    return userRepo.findByRole(User.Role.FARMER);
}

@GetMapping("/users/{id}")
public User getUser(@PathVariable Long id) {

    return userRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
}
@PutMapping("/users/{id}/role")
public String changeRole(
        @PathVariable Long id,
        @RequestParam String role
) {

    User user = userRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));

    user.setRole(User.Role.valueOf(role));

    userRepo.save(user);

    return "Role updated to " + role;
}


}
