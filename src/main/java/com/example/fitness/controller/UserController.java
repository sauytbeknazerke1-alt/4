package com.example.fitness.controller;

import com.example.fitness.model.User;
import com.example.fitness.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public String create(@RequestBody User user) {
        service.createUser(user);
        return "User created";
    }

    @GetMapping("/{id}")
    public User get(@PathVariable int id) {
        return service.getUser(id);
    }

    @PutMapping
    public String update(@RequestBody User user) {
        service.updateUser(user);
        return "User updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.deleteUser(id);
        return "User deleted";
    }
}



