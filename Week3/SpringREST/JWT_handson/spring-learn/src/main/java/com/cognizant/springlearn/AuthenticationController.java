package com.cognizant.springlearn;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final JwtUtil jwtUtil;

    public AuthenticationController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        // Hardcoded demo credentials — real apps would check a database
        if ("admin".equals(request.getUsername()) && "password123".equals(request.getPassword())) {
            return jwtUtil.generateToken(request.getUsername());
        }
        throw new RuntimeException("Invalid credentials");
    }
}