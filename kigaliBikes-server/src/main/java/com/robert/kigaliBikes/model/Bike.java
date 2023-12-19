package com.robert.kigaliBikes.model;

import com.robert.kigaliBikes.enums.BikeStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "bikes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Model is required")
    private String model;

    @NotEmpty(message = "Type is required")
    private String type;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Availability status is required")
    private BikeStatus status;

    private String imagePath;
}
