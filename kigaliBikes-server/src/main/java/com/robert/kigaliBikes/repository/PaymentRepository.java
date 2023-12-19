package com.robert.kigaliBikes.repository;

import com.robert.kigaliBikes.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByUserId(Long userId);

    List<Payment> findByRideId(Long rideId);

    // Optional: Custom query methods can be added here if needed
    // For example, findByStatus, findByUser, etc.
}
