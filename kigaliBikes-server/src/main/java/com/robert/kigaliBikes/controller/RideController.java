package com.robert.kigaliBikes.controller;

import com.robert.kigaliBikes.dto.RideRequest;
import com.robert.kigaliBikes.model.Bike;
import com.robert.kigaliBikes.model.Ride;
import com.robert.kigaliBikes.model.User;
import com.robert.kigaliBikes.service.BikeService;
import com.robert.kigaliBikes.service.RideService;
import com.robert.kigaliBikes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    private final RideService rideService;
    private final UserService userService;
    private final BikeService bikeService;

    @Autowired
    public RideController(RideService rideService, UserService userService, BikeService bikeService) {
        this.rideService = rideService;
        this.userService = userService;
        this.bikeService = bikeService;
    }

    @PostMapping("/start")
    public ResponseEntity<Ride> startRide(@RequestBody RideRequest rideRequest) {
        User user = userService.getUserById(rideRequest.getUserId());
        Bike bike = bikeService.getBikeById(rideRequest.getBikeId());

        Ride startedRide = rideService.startRide(user, bike);
        return new ResponseEntity<>(startedRide, HttpStatus.CREATED);
    }

    @PutMapping("/end/{rideId}")
    public ResponseEntity<Ride> endRide(@PathVariable Long rideId) {
        Ride endedRide = rideService.endRide(rideId);
        return new ResponseEntity<>(endedRide, HttpStatus.OK);
    }

    @PutMapping("/{rideId}")
    public ResponseEntity<Ride> updateRide(
            @PathVariable Long rideId,
            @RequestBody RideRequest updatedRide) {
        Ride updated = rideService.updateRide(rideId, updatedRide.toRide());
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/{rideId}")
    public ResponseEntity<Ride> getRideById(@PathVariable Long rideId) {
        Ride ride = rideService.getRideById(rideId);
        return ride != null ?
                new ResponseEntity<>(ride, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{rideId}/track-distance")
    public ResponseEntity<Ride> trackDistance(
            @PathVariable Long rideId,
            @RequestParam double distanceTraveled) {
        Ride updatedRide = rideService.trackDistance(rideId, distanceTraveled);
        return new ResponseEntity<>(updatedRide, HttpStatus.OK);
    }

//    private User getUserFromRequest(RideRequest rideRequest) {
//        // Implement conversion logic based on your actual structure
//        // For simplicity, assuming you have a UserService with a method like getUserById
//        return userService.getUserById(rideRequest.getUserId());
//    }
//
//    private Bike getBikeFromRequest(RideRequest rideRequest) {
//        // Implement conversion logic based on your actual structure
//        // For simplicity, assuming you have a BikeService with a method like getBikeById
//        return bikeService.getBikeById(rideRequest.getBikeId());
//    }
}
