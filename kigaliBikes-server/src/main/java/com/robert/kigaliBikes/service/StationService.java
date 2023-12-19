package com.robert.kigaliBikes.service;

import com.robert.kigaliBikes.exception.StationNotFoundException;
import com.robert.kigaliBikes.model.Station;
import com.robert.kigaliBikes.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StationService implements StationUI {

    private final StationRepository stationRepository;

    @Autowired
    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    @Transactional
    public Station addStation(String name, Double latitude, Double longitude, Integer availableSlots) {
        try {
            // Implement add station logic, e.g., creating a new station and saving it
            Station station = new Station();
            station.setName(name);
            station.setLatitude(latitude);
            station.setLongitude(longitude);
            station.setAvailableSlots(availableSlots);

            return stationRepository.save(station);
        } catch (Exception e) {
            handleException("Error adding station", e);
            return null; // or throw a custom exception if needed
        }
    }

    @Override
    @Transactional
    public Station updateStation(Long stationId, Station updatedStation) {
        try {
            validateStationId(stationId);

            Station existingStation = stationRepository.findById(stationId)
                    .orElseThrow(() -> new StationNotFoundException("Station not found with ID: " + stationId));

            // Update station details based on the provided updatedStation
            existingStation.setName(updatedStation.getName());
            existingStation.setLatitude(updatedStation.getLatitude());
            existingStation.setLongitude(updatedStation.getLongitude());
            existingStation.setAvailableSlots(updatedStation.getAvailableSlots());

            return existingStation;
        } catch (Exception e) {
            handleException("Error updating station", e);
            return null; // or throw a custom exception if needed
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Station getStationById(Long stationId) {
        try {
            validateStationId(stationId);

            return stationRepository.findById(stationId)
                    .orElseThrow(() -> new StationNotFoundException("Station not found with ID: " + stationId));
        } catch (Exception e) {
            handleException("Error getting station by ID", e);
            return null; // or throw a custom exception if needed
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    private void validateStationId(Long stationId) {
        if (stationId == null || stationId <= 0) {
            throw new IllegalArgumentException("Invalid station ID: " + stationId);
        }
    }

    private void handleException(String message, Exception e) {
        // Log the exception and rethrow a custom exception if needed
        throw new RuntimeException(message + ": " + e.getMessage(), e);
    }
}
