package com.srfzz.tickets.mapper;

import com.srfzz.tickets.domain.CreateEventRequest;
import com.srfzz.tickets.domain.CreateTicketTypeRequest;
import com.srfzz.tickets.domain.entities.Event;
import com.srfzz.tickets.domain.entities.TicketType;
import com.srfzz.tickets.dto.CreateEventRequestDto;
import com.srfzz.tickets.dto.CreateEventResponseDto;
import com.srfzz.tickets.dto.CreateTicketTypeRequestDto;
import com.srfzz.tickets.dto.CreateTicketTypeResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {
    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);
    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateTicketTypeResponseDto toDto(TicketType ticketType);
    CreateEventResponseDto toDto(Event event);



}
