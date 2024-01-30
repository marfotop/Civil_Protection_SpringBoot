package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RestController
@AllArgsConstructor
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from secured endpoint");
    }

    @GetMapping ("/userList")
    public Iterable<User> getAllMovies(){
        return userRepository.findAll();
    }

    @GetMapping("/find/{id}")
    public User findById(@PathVariable Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            return userOptional.get();
        } else return null;
    }

    @GetMapping("/test")
    public String test(){
        return "Hello";
    }

    @PostMapping("/registerUser")
    public User registerUser(@RequestBody Map<String,String> body){

        System.out.println("Received registration request: " + body);

        User user = new User();
        user.setFirstName(body.get("firstName"));
        user.setLastName(body.get("lastName"));
        user.setEmail(body.get("email"));
        user.setUsername(body.get("username"));
        user.setPassword(body.get("password"));
        return userRepository.save(user);
    }

}
