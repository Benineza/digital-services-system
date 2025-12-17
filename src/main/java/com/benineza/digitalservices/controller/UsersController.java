package com.benineza.digitalservices.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.benineza.digitalservices.model.User;
import com.benineza.digitalservices.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    // CREATE USER (SIGN UP)
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // GET ALL USERS (ADMIN)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // LOGIN BY EMAIL
    @GetMapping("/login")
    public User login(@RequestParam String email) {
        return userService.loginByEmail(email);
    }
}
