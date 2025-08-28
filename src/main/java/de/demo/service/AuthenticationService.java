package de.demo.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationService {

    public boolean isValidToken(String token) {
        // Dummy-Validierung, später echte Logik oder DB-Abfrage
        return token != null && token.equals("admin-token");
    }

    public String extractUserIdFromToken(String token) {
        // Dummy-UserId
        return "user123";
    }
}
