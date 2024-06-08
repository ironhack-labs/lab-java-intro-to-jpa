package com.ironhack.labjavaintrotojpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor      // Generates a no-args constructor
@AllArgsConstructor     // Generates an all-args constructor

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;
    private String flightNumber;
    private String aircraft;
    private Integer totalAircraftSeats;
    private Integer flightMileage;
}