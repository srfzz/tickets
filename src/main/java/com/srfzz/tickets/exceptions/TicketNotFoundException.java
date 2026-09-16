package com.srfzz.tickets.exceptions;

import java.util.UUID;

public class TicketNotFoundException extends RuntimeException{


    public TicketNotFoundException(UUID ticketId) {
        super("Ticket with id " + ticketId + " not found");

    }
    public TicketNotFoundException(String message) {
        super(message);
    }
}
