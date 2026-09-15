package com.srfzz.tickets.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(of= "id")
@EntityListeners(AuditingEntityListener.class)
@Table(name="users")
public class User {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
    private UUID id;

    @Column(name="name" ,nullable = false)
    private String name;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    //TODO:ORGANIZE EVENTS


    //TODO:ATTENDING EVENTS


    //TODO: STAFFING EVENTS

    @CreatedDate
    @Column(name ="created_at",nullable = false,updatable = false)
    private Instant createdAt;
    @LastModifiedDate
    @Column(name ="updated_at",nullable = false,updatable = true)
    private Instant updatedAt;
}



