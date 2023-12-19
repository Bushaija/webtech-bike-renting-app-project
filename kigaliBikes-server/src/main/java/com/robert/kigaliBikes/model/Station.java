package com.robert.kigaliBikes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "stations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Station name is required")
    private String name;

    @NotNull(message = "Latitude is required")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    private Double longitude;

    @NotNull(message = "Available slots is required")
    private Integer availableSlots;

}
