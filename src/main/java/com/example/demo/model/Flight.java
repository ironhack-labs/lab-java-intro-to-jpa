package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
//private Integer id;
    // Private member variables
   // private static Integer idCounter = 0;
    private Integer flightId;
    private String flightNumber;
    private String aircraft;
    private Integer totalAircraftSeats;
    private Integer flightMileage;

    // Empty constructor (needed by Hibernate)
    //public Flight() {
        // Initialize flightId with a unique identifier
       // this.flightId = ++idCounter;
    //}

    // Parameterized constructor
    public Flight(String flightNumber, String aircraft, int totalAircraftSeats, int flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
       // this.flightId = ++idCounter;
    }

    public Flight() {

    }

    // Getter and setter methods
    public int getFlightId() {
        return flightId;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setTotalAircraftSeats(int totalAircraftSeats) {
        this.totalAircraftSeats = totalAircraftSeats;
    }

    public int getTotalAircraftSeats() {
        return totalAircraftSeats;
    }

    public void setFlightMileage(int flightMileage) {
        this.flightMileage = flightMileage;
    }

    public int getFlightMileage() {
        return flightMileage;
    }
}
