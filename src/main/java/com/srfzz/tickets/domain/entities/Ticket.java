package com.srfzz.tickets.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.ArrayList;
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
@Table(name="tickets")
public class Ticket {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    @Column(nullable = false,unique = true)
    private UUID  id;

    @Column(nullable = false,name ="status")
    @Enumerated(EnumType.STRING)
    private TicketStatusEnum status;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_type_id")
    private TicketType ticketType;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="purchaser_id")
    private User purchaser;

    //TODO:TICKET Validtaion
    @JsonIgnore
    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<TicketValidation> ticketValidations = new ArrayList<>();

    //TODO:QR CODE
    @JsonIgnore
    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<QrCode> qrCodes = new ArrayList<>();
    @CreatedDate
    @Column(name ="created_at",nullable = false,updatable = false)
    private Instant createdAt;
    @LastModifiedDate
    @Column(name ="updated_at",nullable = false)
    private Instant updatedAt;
}
