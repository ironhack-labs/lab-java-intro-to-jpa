package com.ironhack.labweek304.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "flights")

public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String flightId;

    private String flightNumber;
    private String aircraft;
    private int totalAircraftSeats;
    private int flightMileage;

    public Flight(String flightId, String flightNumber, String aircraft, int totalAircraftSeats, int flightMileage) {
        this.flightId = flightId;
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }


}
