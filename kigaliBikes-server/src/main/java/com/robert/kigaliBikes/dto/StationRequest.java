package com.robert.kigaliBikes.dto;

import com.robert.kigaliBikes.model.Station;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StationRequest {
    private String name;
    private Double latitude;
    private Double longitude;
    private Integer availableSlots;

    // Add getters and setters

//    public Station toStation() {
//        Station station = new Station();
//        station.setName(this.name);
//        station.setLatitude(this.latitude);
//        station.setLongitude(this.longitude);
//        station.setAvailableSlots(this.availableSlots);
//        return station;
//    }
}
