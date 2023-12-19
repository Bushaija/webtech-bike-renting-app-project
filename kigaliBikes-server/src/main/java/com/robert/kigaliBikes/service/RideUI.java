package com.robert.kigaliBikes.service;

import com.robert.kigaliBikes.model.Bike;
import com.robert.kigaliBikes.model.Ride;
import com.robert.kigaliBikes.model.User;

public interface RideUI {

    /**
     * Start a new ride and record the start time.
     * @param user The user initiating the ride.
     * @param bike The bike being used for the ride.
     * @return The created ride entity.
     */
    Ride startRide(User user, Bike bike);

    /**
     * End the ongoing ride and record the end time.
     * @param rideId The ID of the ride to be ended.
     * @return The updated ride entity with end time and distance traveled (if applicable).
     */
    Ride endRide(Long rideId);

    /**
     * Update the details of an existing ride.
     * @param rideId The ID of the ride to be updated.
     * @param updatedRide The updated ride information.
     * @return The updated ride entity.
     */
    Ride updateRide(Long rideId, Ride updatedRide);

    /**
     * Retrieve ride information by ride ID.
     * @param rideId The ID of the ride to retrieve.
     * @return The ride entity with the specified ID.
     */
    Ride getRideById(Long rideId);

    /**
     * Optionally, track the distance traveled during a ride.
     * @param rideId The ID of the ride.
     * @param distanceTraveled The distance traveled during the ride.
     * @return The updated ride entity with distance information.
     */
    Ride trackDistance(Long rideId, double distanceTraveled);
}

