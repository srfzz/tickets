package com.srfzz.tickets.services;

import com.srfzz.tickets.domain.CreateEventRequest;
import com.srfzz.tickets.domain.entities.Event;

import java.util.UUID;

public interface EventService {

    Event createEvent(UUID organizerId, CreateEventRequest createEventRequest);
}
