package com.robert.kigaliBikes.controller;

import com.robert.kigaliBikes.dto.ReservationRequest;
import com.robert.kigaliBikes.model.Reservation;
import com.robert.kigaliBikes.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody @Validated ReservationRequest reservationRequest) {
        Reservation createdReservation = reservationService.createReservation(
                reservationRequest.getUserId(),
                reservationRequest.getBikeId(),
                reservationRequest.getBikeModel(),
                reservationRequest.getBikeType(),
                reservationRequest.getReservationDateTime(),
                reservationRequest.getDurationInMinutes()
        );
        return new ResponseEntity<>(createdReservation, HttpStatus.CREATED);
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<Reservation> updateReservation(
            @PathVariable Long reservationId,
            @RequestBody @Validated ReservationRequest updatedReservation) {
        Reservation updated = reservationService.updateReservation(reservationId, updatedReservation.toReservation());
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long reservationId) {
        Reservation reservation = reservationService.getReservationById(reservationId);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@PathVariable Long userId) {
        List<Reservation> reservations = reservationService.getReservationsByUser(userId);
        return ResponseEntity.ok(reservations);
    }

    @PostMapping("/validate")
    public ResponseEntity<Boolean> validateReservation(@RequestBody @Validated ReservationRequest reservationRequest) {
        boolean isValid = reservationService.validateReservation(
                reservationRequest.getReservationDateTime(),
                reservationRequest.getDurationInMinutes()
        );
        return ResponseEntity.ok(isValid);
    }
}
