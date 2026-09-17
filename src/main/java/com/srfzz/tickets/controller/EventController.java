package com.srfzz.tickets.controller;

import com.srfzz.tickets.domain.CreateEventRequest;
import com.srfzz.tickets.domain.entities.Event;
import com.srfzz.tickets.dto.CreateEventRequestDto;
import com.srfzz.tickets.dto.CreateEventResponseDto;
import com.srfzz.tickets.mapper.EventMapper;
import com.srfzz.tickets.services.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
@Slf4j
public class EventController {
    private final EventService eventService;
    private final EventMapper eventMapper;
    @PostMapping
    public ResponseEntity<CreateEventResponseDto> createEvent(@Valid @RequestBody CreateEventRequestDto createEventRequestDto, @AuthenticationPrincipal Jwt jwt) {
        CreateEventRequest createEventRequest=eventMapper.fromDto(createEventRequestDto);
         UUID organizerId =UUID.fromString(jwt.getSubject());
        Event createdEvent=eventService.createEvent(organizerId,createEventRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventMapper.toDto(createdEvent));


    }
}
