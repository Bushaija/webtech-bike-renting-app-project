package com.robert.kigaliBikes.service;

import com.robert.kigaliBikes.enums.UserRole;
import com.robert.kigaliBikes.model.User;

public interface UserUI {

    /**
     * Register a new user with the specified details.
     * @param username The username for the new user.
     * @param password The password for the new user.
     * @param email The email address for the new user.
     * @param role The role assigned to the new user.
     * @return The created user entity.
     */
    User registerUser(String username, String password, String email, UserRole role);

    /**
     * Update the details of an existing user.
     * @param userId The ID of the user to be updated.
     * @param updatedUser The updated user information.
     * @return The updated user entity.
     */
    User updateUser(Long userId, User updatedUser);

    /**
     * Retrieve user information by user ID.
     * @param userId The ID of the user to retrieve.
     * @return The user entity with the specified ID.
     */
    User getUserById(Long userId);

    /**
     * Authenticate a user based on username and password.
     * @param username The username of the user to authenticate.
     * @param password The password of the user to authenticate.
     * @return True if authentication is successful; false otherwise.
     */
    boolean authenticateUser(String username, String password);

    /**
     * Authorize a user based on their role.
     * @param userId The ID of the user to authorize.
     * @param requiredRole The required role for authorization.
     * @return True if the user has the required role; false otherwise.
     */
    boolean authorizeUser(Long userId, UserRole requiredRole);

}

