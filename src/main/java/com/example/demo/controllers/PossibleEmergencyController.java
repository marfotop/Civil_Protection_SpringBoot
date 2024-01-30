package com.example.demo.controllers;

import com.example.demo.models.PossibleEmergencySituations;
import com.example.demo.repositories.PossibleEmergencySituationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PossibleEmergencyController {

    @Autowired
    private PossibleEmergencySituationsRepository repository;

    @GetMapping("/getAllPossible")
    public Iterable<PossibleEmergencySituations> getAll(){
        return repository.findAll();
    }
}
