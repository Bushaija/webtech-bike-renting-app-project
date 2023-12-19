package com.robert.kigaliBikes.service;

import com.robert.kigaliBikes.enums.BikeStatus;
import com.robert.kigaliBikes.exception.BikeNotFoundException;
import com.robert.kigaliBikes.model.Bike;
import com.robert.kigaliBikes.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;

@Service
public class BikeService implements BikeUI {

    @Value("${upload.directory}")
    private String uploadDirectory;
    private final BikeRepository bikeRepository;

    @Autowired
    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }
    @Override
    @Transactional
    public Bike addBike(String model, String type, BikeStatus status, MultipartFile file) {
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        try {
            file.transferTo(new File(uploadDirectory + File.separator + fileName));
            Bike newBike = new Bike();
            newBike.setModel(model);
            newBike.setType(type);
            newBike.setStatus(status);
            newBike.setImagePath(fileName);
            return bikeRepository.save(newBike);
        } catch (Exception e) {
            handleException("Error adding bike", e);
            return null; // or throw a custom exception if needed
        }
    }

    @Override
    @Transactional
    public Bike updateBike(Long bikeId, Bike updatedBike) {
        validateBikeId(bikeId);

        Bike existingBike = bikeRepository.findById(bikeId)
                .orElseThrow(() -> new BikeNotFoundException("Bike not found with ID: " + bikeId));

        // Update bike details based on the provided updatedBike
        existingBike.setModel(updatedBike.getModel());
        existingBike.setType(updatedBike.getType());
        existingBike.setStatus(updatedBike.getStatus());
        existingBike.setImagePath(updatedBike.getImagePath());

        return existingBike;
    }


    @Override
    @Transactional(readOnly = true)
    public Bike getBikeById(Long bikeId) {
        validateBikeId(bikeId);

        return bikeRepository.findById(bikeId)
                .orElseThrow(() -> new BikeNotFoundException("Bike not found with ID: " + bikeId));
    }


    @Override
    @Transactional(readOnly = true)
    public boolean isBikeAvailable(Long bikeId) {
        try {
            validateBikeId(bikeId);

            Bike bike = getBikeById(bikeId);
            return Objects.requireNonNull(bike).getStatus() == BikeStatus.AVAILABLE;
        } catch (Exception e) {
            handleException("Error checking bike availability", e);
            return false;
        }
    }

    @Override
    @Transactional
    public Bike updateBikeStatus(Long bikeId, BikeStatus newStatus) {
        try {
            validateBikeId(bikeId);

            Bike bike = getBikeById(bikeId);
            Objects.requireNonNull(bike).setStatus(newStatus);

            return bike;
        } catch (Exception e) {
            handleException("Error updating bike status", e);
            return null; // or throw a custom exception if needed
        }
    }

    private void validateBikeId(Long bikeId) {
        if (bikeId == null || bikeId <= 0) {
            throw new IllegalArgumentException("Invalid bike ID: " + bikeId);
        }
    }

    private void handleException(String message, Exception e) {
        // Log the exception and perform additional error handling if needed
        System.err.println(message + ": " + e.getMessage());
    }
}
