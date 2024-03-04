package org.example.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @Column(name = "flight_number")
    private String flightNumber;

    @Column(name = "aircraft_type")
    private String aircraft;

    @Column(name = "total_aircraft_seats")
    private int totalAircraftSeats;

    @Column(name = "flight_mileage")
    private int flightMileage;

    // Empty constructor for Hibernate
    public Flight() {
    }

    // Parameterized constructor
    public Flight(String flightNumber, String aircraft, int totalAircraftSeats, int flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }

    // Getters and setters

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public int getTotalAircraftSeats() {
        return totalAircraftSeats;
    }

    public void setTotalAircraftSeats(int totalAircraftSeats) {
        this.totalAircraftSeats = totalAircraftSeats;
    }

    public int getFlightMileage() {
        return flightMileage;
    }

    public void setFlightMileage(int flightMileage) {
        this.flightMileage = flightMileage;
    }
}
