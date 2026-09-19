package com.srfzz.tickets.security;

import org.springframework.security.oauth2.jwt.Jwt;

import java.util.UUID;

public final class AuthUtils {
    private AuthUtils() {}
    public static UUID currentUser(Jwt jwt) {
        if (jwt == null || jwt.getSubject() == null) {
            throw new IllegalStateException("No authenticated user");
        }
        return UUID.fromString(jwt.getSubject());
    }
}
