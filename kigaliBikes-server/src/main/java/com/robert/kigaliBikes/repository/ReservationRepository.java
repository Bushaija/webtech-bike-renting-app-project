package com.robert.kigaliBikes.repository;

import com.robert.kigaliBikes.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long userId);

    // Optional: Custom query methods can be added here if needed
    // For example, findByUser, findByBike, etc.

}