package com.robert.kigaliBikes.dto;

import com.robert.kigaliBikes.enums.BikeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BikeRequest {
    private String model;
    private String type;
    private BikeStatus status;
}
