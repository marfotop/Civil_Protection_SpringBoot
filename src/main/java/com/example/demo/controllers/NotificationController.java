package com.example.demo.controllers;


import com.example.demo.models.NotificationForEmergency;
import com.example.demo.repositories.NotificationForEmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {

    @Autowired
    private NotificationForEmergencyRepository repository;

    @GetMapping("/getAllNotifications")
    public Iterable<NotificationForEmergency> getNotifications(){
        return repository.findAll();
    }

}
