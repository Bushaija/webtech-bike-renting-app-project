package com.robert.kigaliBikes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "rides")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Start time is required")
    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "bike_id", nullable = false)
    private Bike bike;

    // Optional: Include a field to track the distance traveled during the ride
    // private double distanceTraveled;

    public void endRide() {
        this.endTime = LocalDateTime.now();
        // Additional logic for calculating distance traveled, updating statistics, etc.
    }
}
