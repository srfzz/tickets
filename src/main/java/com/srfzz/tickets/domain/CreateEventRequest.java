    package com.srfzz.tickets.domain;


    import com.srfzz.tickets.domain.entities.EventStatusEnum;
    import com.srfzz.tickets.domain.entities.TicketType;
    import com.srfzz.tickets.domain.entities.User;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    import java.time.Instant;
    import java.util.ArrayList;
    import java.util.List;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class CreateEventRequest {
        private String name;
        private Instant start;
        private Instant end;
        private String venue;
        private Instant salesStart;
        private Instant salesEnd;
        private EventStatusEnum status;
        private User organizer;
        private List<TicketType> ticketTypes = new ArrayList<>();

    }
