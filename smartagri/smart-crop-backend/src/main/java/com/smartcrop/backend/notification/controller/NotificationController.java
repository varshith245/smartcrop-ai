package com.smartcrop.backend.notification.controller;

import com.smartcrop.backend.notification.entity.Notification;
import com.smartcrop.backend.notification.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationRepository repository;

    // Admin sends notification
    @PostMapping
    public Notification sendNotification(@RequestBody Notification notification){
        return repository.save(notification);
    }

    // Farmer receives notifications
    @GetMapping("/user/{userId}")
    public List<Notification> getUserNotifications(@PathVariable Long userId){
        return repository.findByUserId(userId);
    }
}