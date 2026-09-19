package com.srfzz.tickets.dto;

import com.srfzz.tickets.domain.entities.EventStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListEventResponseDto {
    private UUID id;
    private String name;
    private Instant start;
    private Instant end;
    private String venue;
    private Instant salesStart;
    private Instant salesEnd;
    private EventStatusEnum status;
    private List<ListEventTicketTypeResponseDto>  ticketTypes = new ArrayList<>();
}
