package com.robert.kigaliBikes.controller;

import com.robert.kigaliBikes.dto.BikeRequest;
import com.robert.kigaliBikes.enums.BikeStatus;
import com.robert.kigaliBikes.model.Bike;
import com.robert.kigaliBikes.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/bikes")
public class BikeController {

    private final BikeService bikeService;

    @Autowired
    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    @PostMapping
    public ResponseEntity<Bike> addBike(@RequestBody BikeRequest request, @RequestParam("file") MultipartFile file) {
        Bike newBike = bikeService.addBike(request.getModel(), request.getType(), request.getStatus(), file);
        return new ResponseEntity<>(newBike, HttpStatus.CREATED);
    }



    @PutMapping("/{bikeId}")
    public ResponseEntity<Bike> updateBike(@PathVariable Long bikeId, @RequestBody Bike updatedBike) {
        Bike updated = bikeService.updateBike(bikeId, updatedBike);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @GetMapping("/{bikeId}")
    public ResponseEntity<Bike> getBikeById(@PathVariable Long bikeId) {
        Bike bike = bikeService.getBikeById(bikeId);
        return bike != null ? new ResponseEntity<>(bike, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{bikeId}/availability")
    public ResponseEntity<String> checkBikeAvailability(@PathVariable Long bikeId) {
        boolean isAvailable = bikeService.isBikeAvailable(bikeId);
        return isAvailable ? new ResponseEntity<>("Bike is available", HttpStatus.OK)
                : new ResponseEntity<>("Bike is not available", HttpStatus.OK);
    }

    @PutMapping("/{bikeId}/status")
    public ResponseEntity<Bike> updateBikeStatus(@PathVariable Long bikeId, @RequestParam BikeStatus newStatus) {
        Bike updated = bikeService.updateBikeStatus(bikeId, newStatus);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
