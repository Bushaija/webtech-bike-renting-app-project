package com.robert.kigaliBikes.service;

import com.robert.kigaliBikes.exception.RideNotFoundException;
import com.robert.kigaliBikes.model.Bike;
import com.robert.kigaliBikes.model.Ride;
import com.robert.kigaliBikes.model.User;
import com.robert.kigaliBikes.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RideService implements RideUI {

    private final RideRepository rideRepository;

    @Autowired
    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    @Override
    @Transactional
    public Ride startRide(User user, Bike bike) {
        try {
            // Implement start ride logic, e.g., setting start time, associating user and bike, etc.
            Ride ride = new Ride();
            ride.setUser(user);
            ride.setBike(bike);
            ride.setStartTime(LocalDateTime.now());

            return rideRepository.save(ride);
        } catch (Exception e) {
            handleException("Error starting ride", e);
            return null; // or throw a custom exception if needed
        }
    }

    @Override
    @Transactional
    public Ride endRide(Long rideId) {
        try {
            validateRideId(rideId);

            Ride existingRide = getRideById(rideId);
            // Implement end ride logic, e.g., setting end time, calculating distance traveled, etc.
            existingRide.endRide();

            return existingRide;
        } catch (Exception e) {
            handleException("Error ending ride", e);
            return null; // or throw a custom exception if needed
        }
    }

    @Override
    @Transactional
    public Ride updateRide(Long rideId, Ride updatedRide) {
        try {
            validateRideId(rideId);

            Ride existingRide = getRideById(rideId);
            // Implement update ride logic based on the provided updatedRide
            // For example, updating start time, end time, user, bike, etc.

            return existingRide;
        } catch (Exception e) {
            handleException("Error updating ride", e);
            return null; // or throw a custom exception if needed
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Ride getRideById(Long rideId) {
        try {
            validateRideId(rideId);

            return rideRepository.findById(rideId)
                    .orElseThrow(() -> new RideNotFoundException("Ride not found with ID: " + rideId));
        } catch (Exception e) {
            handleException("Error getting ride by ID", e);
            return null; // or throw a custom exception if needed
        }
    }

    @Override
    @Transactional
    public Ride trackDistance(Long rideId, double distanceTraveled) {
        try {
            validateRideId(rideId);

            Ride existingRide = getRideById(rideId);
            // Implement logic to track distance traveled during the ride
            // For example, updating a distanceTraveled field in the Ride entity

            return existingRide;
        } catch (Exception e) {
            handleException("Error tracking distance for ride", e);
            return null; // or throw a custom exception if needed
        }
    }

    private void validateRideId(Long rideId) {
        if (rideId == null || rideId <= 0) {
            throw new IllegalArgumentException("Invalid ride ID: " + rideId);
        }
    }

    private void handleException(String message, Exception e) {
        // Log the exception and perform additional error handling if needed
        System.err.println(message + ": " + e.getMessage());
    }
}
