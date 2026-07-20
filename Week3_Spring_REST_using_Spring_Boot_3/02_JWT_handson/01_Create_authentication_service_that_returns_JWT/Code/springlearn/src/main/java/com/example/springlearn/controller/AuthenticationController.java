package com.example.springlearn.controller;

import com.example.springlearn.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public ResponseEntity<Map<String, String>> authenticate(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        
        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // Decode Base64 from Authorization Header
        String base64Cred = authHeader.substring(6);
        byte[] decodedBytes = Base64.getDecoder().decode(base64Cred);
        String creds = new String(decodedBytes, StandardCharsets.UTF_8);

        // credentials format is "username:password"
        String[] values = creds.split(":", 2);
        String username = values[0];

        // Generate JWT Token
        String token = jwtUtil.generateToken(username);

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }
}