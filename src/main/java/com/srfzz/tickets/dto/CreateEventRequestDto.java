package com.srfzz.tickets.dto;


import com.srfzz.tickets.domain.entities.EventStatusEnum;
import com.srfzz.tickets.domain.entities.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEventRequestDto {
    @NotBlank(message = "Event name is Required")
    private String name;
    private Instant start;
    private Instant end;
    @NotBlank(message = "Event venue Is Required")
    private String venue;
    private Instant salesStart;
    private Instant salesEnd;
    @NotNull(message = "Event Status is Required")
    private EventStatusEnum status;
    private User organizer;
    @NotNull(message = "Atleast One Ticket Type is Required")
    @Valid
    private List<CreateTicketTypeRequestDto> ticketTypes;
}
