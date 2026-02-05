package com.example.fitness.controller;

import com.example.fitness.model.User;
import com.example.fitness.service.FitnessApp;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final FitnessApp fitnessApp;

    public UserController(FitnessApp fitnessApp) {
        this.fitnessApp = fitnessApp;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return fitnessApp.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return fitnessApp.addUser(user);
    }
}

