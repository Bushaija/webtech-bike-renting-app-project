package com.robert.kigaliBikes.service;

import com.robert.kigaliBikes.enums.UserRole;
import com.robert.kigaliBikes.exception.UserNotFoundException;
import com.robert.kigaliBikes.model.User;
import com.robert.kigaliBikes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserUI{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    @Transactional
    public User registerUser(String username, String password, String email, UserRole role) {
        try {
            validateRegistrationParameters(username, email);

            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(passwordEncoder.encode(password));
            newUser.setEmail(email);
            newUser.setRole(role);

            return userRepository.save(newUser);
        } catch (Exception e) {
            // Log the exception and rethrow a custom exception if needed
            throw new RuntimeException("Error registering user: " + e.getMessage(), e);
        }
    }


    @Override
    @Transactional
    public User updateUser(Long userId, User updatedUser) {
        try {
            validateUserId(userId);

            User existingUser = userRepository.findById(userId)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found with ID: " + userId));

            // Update user details based on the provided updatedUser
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setRole(updatedUser.getRole());

            return existingUser;
        } catch (Exception e) {
            // Log the exception and rethrow a custom exception if needed
            throw new RuntimeException("Error updating user: " + e.getMessage(), e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long userId) {
        try {
            validateUserId(userId);

            return userRepository.findById(userId)
                    .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
        } catch (Exception e) {
            // Log the exception and rethrow a custom exception if needed
            throw new RuntimeException("Error getting user by ID: " + e.getMessage(), e);
        }
    }


    @Override
    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));

        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public boolean authorizeUser(Long userId, UserRole requiredRole) {
        User user = getUserById(userId);
        return user.getRole() == requiredRole;
    }

    private void validateRegistrationParameters(String username, String email) {
        if (userRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Username is already taken: " + username);
        }

        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email is already registered: " + email);
        }
    }

    private void validateUserId(Long userId) {
        try {
            if (userId == null || userId <= 0) {
                throw new IllegalArgumentException("Invalid user ID: " + userId);
            }
        } catch (Exception e) {
            // Log the exception and rethrow a custom exception if needed
            throw new RuntimeException("Error validating user ID: " + e.getMessage(), e);
        }
    }
}
