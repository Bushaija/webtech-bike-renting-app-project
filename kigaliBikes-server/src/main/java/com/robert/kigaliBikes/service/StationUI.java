package com.robert.kigaliBikes.service;

import com.robert.kigaliBikes.model.Station;

import java.util.List;

public interface StationUI {

    /**
     * Add a new station with the specified details.
     * @param name The name of the new station.
     * @param latitude The latitude of the station location.
     * @param longitude The longitude of the station location.
     * @param availableSlots The number of available slots at the station.
     * @return The created station entity.
     */
    Station addStation(String name, Double latitude, Double longitude, Integer availableSlots);

    /**
     * Update the details of an existing station.
     * @param stationId The ID of the station to be updated.
     * @param updatedStation The updated station information.
     * @return The updated station entity.
     */
    Station updateStation(Long stationId, Station updatedStation);

    /**
     * Retrieve station information by station ID.
     * @param stationId The ID of the station to retrieve.
     * @return The station entity with the specified ID.
     */
    Station getStationById(Long stationId);

    /**
     * Retrieve a list of all stations.
     * @return A list of all station entities.
     */
    List<Station> getAllStations();
}
