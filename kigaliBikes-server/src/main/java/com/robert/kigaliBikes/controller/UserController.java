package com.robert.kigaliBikes.controller;

import com.robert.kigaliBikes.dto.UserCredentialsRequest;
import com.robert.kigaliBikes.dto.UserRegistrationRequest;
import com.robert.kigaliBikes.enums.UserRole;
import com.robert.kigaliBikes.model.User;
import com.robert.kigaliBikes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationRequest request) {
        try {
            User newUser = userService.registerUser(request.getUsername(), request.getPassword(), request.getEmail(), request.getRole());
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            // Log the exception and return a custom error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new User());
        }
    }


    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        User updated = userService.updateUser(userId, updatedUser);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticateUser(@RequestBody UserCredentialsRequest request) {
        boolean isAuthenticated = userService.authenticateUser(request.getUsername(), request.getPassword());
        return isAuthenticated ? new ResponseEntity<>("Authentication successful", HttpStatus.OK)
                : new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/{userId}/authorize")
    public ResponseEntity<String> authorizeUser(@PathVariable Long userId, @RequestParam UserRole requiredRole) {
        boolean isAuthorized = userService.authorizeUser(userId, requiredRole);
        return isAuthorized ? new ResponseEntity<>("User is authorized", HttpStatus.OK)
                : new ResponseEntity<>("User is not authorized", HttpStatus.FORBIDDEN);
    }


}
