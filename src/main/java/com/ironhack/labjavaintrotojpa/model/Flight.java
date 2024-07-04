package com.ironhack.labjavaintrotojpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private int flightId;

    @Column(name = "flight_number", unique = true)
    private String flightNumber;

    @Column(name = "aircraft")
    private String aircraft;

    @Column(name = "total_aircraft_seats")
    private int totalAircraftSeats;

    @Column(name = "flight_mileage")
    private int flightMileage;

    public Flight(String flightNumber, String aircraft, int totalAircraftSeats, int flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }

}
