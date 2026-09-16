package com.srfzz.tickets.exceptions;

import java.util.UUID;

public class UserNotFoundExcpetion extends RuntimeException{
    public UserNotFoundExcpetion(String message) {
        super(message);
    }
    public UserNotFoundExcpetion(UUID userId) {
        super("User with id " + userId + " not found");
    }
}
