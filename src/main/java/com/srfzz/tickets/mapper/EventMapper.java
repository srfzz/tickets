package com.srfzz.tickets.mapper;

import com.srfzz.tickets.domain.CreateEventRequest;
import com.srfzz.tickets.domain.CreateTicketTypeRequest;
import com.srfzz.tickets.domain.entities.Event;
import com.srfzz.tickets.domain.entities.TicketType;
import com.srfzz.tickets.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);
    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateTicketTypeResponseDto toDto(TicketType ticketType);
    CreateEventResponseDto toDto(Event event);

    ListEventTicketTypeResponseDto toListDto(TicketType ticketTypes);
    ListEventResponseDto toListDto(Event event);



}
