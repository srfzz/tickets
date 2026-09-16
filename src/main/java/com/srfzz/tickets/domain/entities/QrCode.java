package com.srfzz.tickets.domain.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="qr_codes")
public class QrCode {
  @Id
  @UuidGenerator(style = UuidGenerator.Style.VERSION_7)
  @Column(nullable = false,unique = true)
  private String id;

  @Column(nullable = false,name = "generated_date_time")
  private Instant generatedDateTime;
  @Enumerated(EnumType.STRING)
  @Column(name="status",nullable = false)
  private QrCodeStatusEnum status;
@Column(nullable = false,name="value")
  private String value;

@JsonIgnore
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="ticket_id")
private Ticket ticket;

  @CreatedDate
  @Column(name ="created_at",nullable = false,updatable = false)
  private Instant createdAt;
  @LastModifiedDate
  @Column(name ="updated_at",nullable = false,updatable = true)
  private Instant updatedAt;
}
