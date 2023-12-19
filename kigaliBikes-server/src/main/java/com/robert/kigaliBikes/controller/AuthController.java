package com.robert.kigaliBikes.controller;

import com.robert.kigaliBikes.dto.AuthenticationRequest;
import com.robert.kigaliBikes.dto.AuthenticationResponse;
import com.robert.kigaliBikes.dto.RegisterRequest;
import com.robert.kigaliBikes.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate (
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
