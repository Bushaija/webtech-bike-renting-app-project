package com.robert.kigaliBikes.dto;

import com.robert.kigaliBikes.model.Reservation;
import com.robert.kigaliBikes.model.User;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {
    private Long userId;
    private Long bikeId;
    private String bikeModel;
    private String bikeType;
    private LocalDateTime reservationDateTime;
    private int durationInMinutes;

    public Reservation toReservation() {
        Reservation reservation = new Reservation();
        reservation.setUser(new User(userId));
        reservation.setBikeId(bikeId);
        reservation.setBikeModel(bikeModel);
        reservation.setBikeType(bikeType);
        reservation.setReservationDateTime(reservationDateTime);
        reservation.setDurationInMinutes(durationInMinutes);
        return reservation;
    }
}
