package com.robert.kigaliBikes.model;

import com.robert.kigaliBikes.enums.ReservationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull(message = "Bike ID is required")
    @Column(name = "bike_id")
    private Long bikeId;

    @NotNull(message = "Bike Model is required")
    @Column(name = "bike_model")
    private String bikeModel;

    @NotNull(message = "Bike Type is required")
    @Column(name = "bike_type")
    private String bikeType;

    @NotNull(message = "Reservation date and time are required")
    @Future(message = "Reservation date must be in the future")
    @Column(name = "reservation_datetime")
    private LocalDateTime reservationDateTime;

    @NotNull(message = "Reservation duration is required")
    @Column(name = "duration_in_minutes")
    private int durationInMinutes;

    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
}
