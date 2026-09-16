package com.srfzz.tickets.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
@EntityListeners(AuditingEntityListener.class)
@Builder
@Table(name="ticket_validations")
public class TicketValidation {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID  id;

    @Enumerated(EnumType.STRING)
    @Column(nullable=false,name="status")
    private TicketValidationStatusEnum status;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_validation_method")
    private TicketValidationMethod validationMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @CreatedDate
    @Column(name="created_at",updatable = false)
    private Instant createdAt;
    @LastModifiedDate
    @Column(name="updated_at")
    private Instant updatedAt;

}
