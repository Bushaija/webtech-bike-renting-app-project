package com.robert.kigaliBikes.repository;

import com.robert.kigaliBikes.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RideRepository extends JpaRepository<Ride, Long> {

    // Optional: Custom query methods can be added here if needed
    // For example, findByUser, findByBike, etc.

}
