package com.robert.kigaliBikes.service;

import com.robert.kigaliBikes.enums.BikeStatus;
import com.robert.kigaliBikes.model.Bike;
import org.springframework.web.multipart.MultipartFile;

public interface BikeUI {

    /**
     * Add a new bike with the specified details.
     * @param model The model of the new bike.
     * @param type The type of the new bike.
     * @param status The availability status of the new bike.
     * @param image The image data of the new bike.
     * @param imagePath The image path of the new bike.
     * @return The created bike entity.
     */
    Bike addBike(String model, String type, BikeStatus status, MultipartFile image);

    /**
     * Update the details of an existing bike.
     * @param bikeId The ID of the bike to be updated.
     * @param updatedBike The updated bike information.
     * @return The updated bike entity.
     */
    Bike updateBike(Long bikeId, Bike updatedBike);

    /**
     * Retrieve bike information by bike ID.
     * @param bikeId The ID of the bike to retrieve.
     * @return The bike entity with the specified ID.
     */
    Bike getBikeById(Long bikeId);

    /**
     * Check the availability of a specific bike.
     * @param bikeId The ID of the bike to check.
     * @return True if the bike is available; false otherwise.
     */
    boolean isBikeAvailable(Long bikeId);

    /**
     * Update the status of a specific bike.
     * @param bikeId The ID of the bike to update.
     * @param newStatus The new availability status.
     * @return The updated bike entity.
     */
    Bike updateBikeStatus(Long bikeId, BikeStatus newStatus);
}
