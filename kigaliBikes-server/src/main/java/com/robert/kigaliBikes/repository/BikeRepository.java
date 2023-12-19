package com.robert.kigaliBikes.repository;

import com.robert.kigaliBikes.model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BikeRepository extends JpaRepository<Bike, Long> {
}
