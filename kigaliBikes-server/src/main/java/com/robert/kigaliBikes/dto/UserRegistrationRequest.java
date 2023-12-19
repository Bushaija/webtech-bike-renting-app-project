package com.robert.kigaliBikes.dto;

import com.robert.kigaliBikes.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {
    private String username;
    private String password;
    private String email;
    private UserRole role;

}
