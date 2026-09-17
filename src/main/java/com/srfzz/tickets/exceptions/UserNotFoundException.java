package com.srfzz.tickets.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
    public UserNotFoundException(UUID userId) {
        super("User with id " + userId + " not found");
    }
}
