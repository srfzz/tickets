package com.srfzz.tickets.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of="id")
@Builder
@Table(name="ticket_type")
public class TicketType {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(nullable = false,unique = true)
    private UUID id;

    @Column(nullable = false,name="name",length = 200)
    private String name;

    @Column(nullable = false,name="price")
    private Double price;
    @Column(nullable = false,name="description",columnDefinition = "text")
    private String description;
    @Column(nullable = false,name="total_available")
    private Integer totalAvailable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id",nullable = false)
    private Event event;

    //TODO:Tickets
    @JsonIgnore
    @OneToMany(mappedBy = "ticketType",cascade = CascadeType.ALL)
    private List<Ticket> ticketsList;


    @CreatedDate
    @Column(name="created_at",updatable = false)
    private Instant createdAt;
    @LastModifiedDate
    @Column(name="updated_at")
    private Instant updatedAt;

}
