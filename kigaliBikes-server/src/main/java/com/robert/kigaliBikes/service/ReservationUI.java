package com.robert.kigaliBikes.service;

import com.robert.kigaliBikes.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationUI {

    /**
     * Create a new reservation with the specified details.
     * @param userId The ID of the user making the reservation.
     * @param bikeId The ID of the bike being reserved.
     * @param bikeModel The model of the reserved bike.
     * @param bikeType The type of the reserved bike.
     * @param reservationDateTime The date and time for the reservation.
     * @param durationInMinutes The duration of the reservation in minutes.
     * @return The created reservation entity.
     */
    Reservation createReservation(Long userId, Long bikeId, String bikeModel, String bikeType,
                                  LocalDateTime reservationDateTime, int durationInMinutes);

    /**
     * Update the details of an existing reservation.
     * @param reservationId The ID of the reservation to be updated.
     * @param updatedReservation The updated reservation information.
     * @return The updated reservation entity.
     */
    Reservation updateReservation(Long reservationId, Reservation updatedReservation);

    /**
     * Retrieve reservation details by reservation ID.
     * @param reservationId The ID of the reservation to retrieve.
     * @return The reservation entity with the specified ID.
     */
    Reservation getReservationById(Long reservationId);

    /**
     * Retrieve a list of reservations made by a specific user.
     * @param userId The ID of the user for whom reservations are to be retrieved.
     * @return A list of reservation entities made by the user.
     */
    List<Reservation> getReservationsByUser(Long userId);

    /**
     * Validate reservation dates and durations.
     * @param reservationDateTime The date and time for the reservation.
     * @param durationInMinutes The duration of the reservation in minutes.
     * @return True if the reservation is valid; false otherwise.
     */
    boolean validateReservation(LocalDateTime reservationDateTime, int durationInMinutes);
}

