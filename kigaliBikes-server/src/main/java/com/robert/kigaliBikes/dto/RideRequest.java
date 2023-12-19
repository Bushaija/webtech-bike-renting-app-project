package com.robert.kigaliBikes.dto;

import com.robert.kigaliBikes.model.Ride;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RideRequest {
    private Long userId;
    private Long bikeId;

    public Ride toRide() {
        Ride ride = new Ride();
        ride.setStartTime(LocalDateTime.now()); // Set the start time to the current time
        // Map other relevant fields from the request to the Ride entity
        return ride;
    }
}
