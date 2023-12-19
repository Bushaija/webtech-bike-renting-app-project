package com.robert.kigaliBikes.controller;

import com.robert.kigaliBikes.dto.StationRequest;
import com.robert.kigaliBikes.model.Station;
import com.robert.kigaliBikes.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stations")
public class StationController {

    private final StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping
    public ResponseEntity<Station> addStation(@RequestBody StationRequest stationRequest) {
        Station addedStation = stationService.addStation(
                stationRequest.getName(),
                stationRequest.getLatitude(),
                stationRequest.getLongitude(),
                stationRequest.getAvailableSlots()
        );
        return new ResponseEntity<>(addedStation, HttpStatus.CREATED);
    }

//    @PutMapping("/{stationId}")
//    public ResponseEntity<Station> updateStation(
//            @PathVariable Long stationId,
//            @RequestBody StationRequest updatedStation) {
//        Station updated = stationService.updateStation(stationId, updatedStation.toStation());
//        return new ResponseEntity<>(updated, HttpStatus.OK);
//    }

    @GetMapping("/{stationId}")
    public ResponseEntity<Station> getStationById(@PathVariable Long stationId) {
        Station station = stationService.getStationById(stationId);
        return new ResponseEntity<>(station, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Station>> getAllStations() {
        List<Station> stations = stationService.getAllStations();
        return new ResponseEntity<>(stations, HttpStatus.OK);
    }

}
