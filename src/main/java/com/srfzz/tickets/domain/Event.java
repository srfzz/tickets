package com.srfzz.tickets.domain;

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
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of="id")
@Builder
@Table(name="events")
public class Event {


    @Id
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;
    @Column(name="name",nullable = false,length = 100)
    private String name;
    @Column(name="start",nullable = false)
    private Instant start;
    @Column(name="end",nullable = false)
    private Instant end;
    @Column(name="venue",nullable = false,length = 300)
    private String venue;
    @Column(name="sales_start")
    private Instant salesStart;
    @Column(name="sales_end")
    private Instant salesEnd;
    @Enumerated(EnumType.STRING)
    @Column(name="status",nullable = false)
    private EventStatusEnum status;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "organizer_id",nullable = false)
    private User organizer;

    @JsonIgnore
    @ManyToMany(mappedBy = "attendingEvents")
    private List<User> attendees = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "staffsEvents")
    private List<User> staffs=new ArrayList<>();

    @CreatedDate
    @Column(name="created_at",updatable = false,nullable = false)
    private Instant createdAt;
    @LastModifiedDate
    @Column(name = "updated_at",updatable = true,nullable = false)
    private Instant updatedAt;
}
