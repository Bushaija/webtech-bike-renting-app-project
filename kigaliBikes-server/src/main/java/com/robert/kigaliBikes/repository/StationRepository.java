package com.robert.kigaliBikes.repository;

import com.robert.kigaliBikes.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Long> {
    // Optional: Custom query methods can be added here if needed
    // For example, findByName, findByLocation, etc.
}
