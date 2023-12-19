package com.robert.kigaliBikes.service;

import com.robert.kigaliBikes.exception.ReservationNotFoundException;
import com.robert.kigaliBikes.model.Reservation;
import com.robert.kigaliBikes.model.User;
import com.robert.kigaliBikes.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService implements ReservationUI {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    @Transactional
    public Reservation createReservation(Long userId, Long bikeId, String bikeModel, String bikeType,
                                         LocalDateTime reservationDateTime, int durationInMinutes) {
        try {
            validateReservation(reservationDateTime, durationInMinutes);

            Reservation reservation = new Reservation();
            // Set reservation details based on the provided parameters
            reservation.setUser(new User(userId)); // Assuming you have a User entity with an appropriate constructor
            reservation.setBikeId(bikeId);
            reservation.setBikeModel(bikeModel);
            reservation.setBikeType(bikeType);
            reservation.setReservationDateTime(reservationDateTime);
            reservation.setDurationInMinutes(durationInMinutes);

            return reservationRepository.save(reservation);
        } catch (Exception e) {
            handleException("Error creating reservation", e);
            return null; // or throw a custom exception if needed
        }
    }


    @Override
    @Transactional
    public Reservation updateReservation(Long reservationId, Reservation updatedReservation) {
        try {
            validateReservation(updatedReservation.getReservationDateTime(), updatedReservation.getDurationInMinutes());

            Reservation existingReservation = getReservationById(reservationId);
            // Update reservation details based on the provided updatedReservation
            existingReservation.setBikeModel(updatedReservation.getBikeModel());
            existingReservation.setBikeType(updatedReservation.getBikeType());
            existingReservation.setReservationDateTime(updatedReservation.getReservationDateTime());
            existingReservation.setDurationInMinutes(updatedReservation.getDurationInMinutes());

            return existingReservation;
        } catch (Exception e) {
            handleException("Error updating reservation", e);
            return null; // or throw a custom exception if needed
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Reservation getReservationById(Long reservationId) {
        try {
            validateReservationId(reservationId);

            return reservationRepository.findById(reservationId)
                    .orElseThrow(() -> new ReservationNotFoundException("Reservation not found with ID: " + reservationId));
        } catch (Exception e) {
            handleException("Error getting reservation by ID", e);
            return null; // or throw a custom exception if needed
        }
    }
    @Override
    @Transactional(readOnly = true)
    public List<Reservation> getReservationsByUser(Long userId) {
        // Implement logic to retrieve reservations for a specific user
        // ...

        return reservationRepository.findByUserId(userId);
    }
    @Override
    public boolean validateReservation(LocalDateTime reservationDateTime, int durationInMinutes) {
        return false;
    }

    private void validateReservationId(Long reservationId) {
        if (reservationId == null || reservationId <= 0) {
            throw new IllegalArgumentException("Invalid reservation ID: " + reservationId);
        }
    }

    private void handleException(String message, Exception e) {
        // Log the exception and perform additional error handling if needed
        System.err.println(message + ": " + e.getMessage());
    }
}
