package com.example.demo.controllers;

import com.example.demo.models.ConfirmedEmergencySituations;
import com.example.demo.repositories.ConfirmedEmergencySituationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfirmedEmergencyController {

    @Autowired
    private ConfirmedEmergencySituationsRepository repository;

    @GetMapping("/getAllConfirmed")
    public Iterable<ConfirmedEmergencySituations> getAll(){
        return repository.findAll();
    }
}
