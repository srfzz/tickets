package com.srfzz.tickets.services.impl;


import com.srfzz.tickets.domain.CreateEventRequest;
import com.srfzz.tickets.domain.entities.Event;
import com.srfzz.tickets.domain.entities.TicketType;
import com.srfzz.tickets.domain.entities.User;
import com.srfzz.tickets.exceptions.EventNotFoundException;
import com.srfzz.tickets.exceptions.UserNotFoundException;
import com.srfzz.tickets.repository.EventRepository;
import com.srfzz.tickets.repository.UserRepository;
import com.srfzz.tickets.services.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    @Override
    public Event createEvent(UUID organizerId, CreateEventRequest req) {
        log.info("Creating event '{}' for organizer {}", req.getName(), organizerId);
        User user= userRepository.findById(organizerId).orElseThrow(()-> new UserNotFoundException(organizerId));



        Event createdEvent = Event.builder().name(req.getName())
                .start(req.getStart())
                .end(req.getEnd())
                .venue(req.getVenue())
                .salesStart(req.getSalesStart())
                .salesEnd(req.getSalesEnd())
                .status(req.getStatus())
                .organizer(user)
                // .ticketTypes(ticketTypesTocreate)
                .build();
        List<TicketType> ticketTypesTocreate= req.getTicketTypes().stream().map(ticketType -> {
            return TicketType.builder()
                    .name(ticketType.getName())
                    .price(ticketType.getPrice())
                    .description(ticketType.getDescription())
                    .event(createdEvent)
                    .totalAvailable(ticketType.getTotalAvailable())
                    .build();
        }).toList();
        createdEvent.setTicketTypes(ticketTypesTocreate);
        log.info("Created Event {} for organizer {}", createdEvent, organizerId);
       return eventRepository.save(createdEvent);

    }

    @Override
    @Transactional(readOnly = true)
    public Page<Event> listEventForOrganizer(UUID organizerid, Pageable pageable) {
        return eventRepository.findByOrganizerId(organizerid, pageable);
    }

    @Override
    public Optional<Event> getEventByIdAndOrganizerId(UUID eventId, UUID organizerId) {
        return eventRepository.findByIdAndOrganizerId(eventId, organizerId);
    }


}
