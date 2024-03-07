package com.airline.lab.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private int flightId; // an auto-generated unique identifier, private member
    @Column(name = "flight_number")
    private String flightNumber; // unique identifier, private member
    @Column(name = "aircraft")
    private String aircraft; // private member
    @Column(name = "aircraft_seats")
    private int totalAircraftSeats; // private member
    @Column(name = "flight_mileage")
    private int flightMileage; // private member

    // Empty constructor
    public Flight() {
    }

    // Parameterized constructor

    public Flight(String flightNumber, String aircraft, int totalAircraftSeats, int flightMileage) {
        setFlightNumber(flightNumber);
        setAircraft(aircraft);
        setTotalAircraftSeats(totalAircraftSeats);
        setFlightMileage(flightMileage);
    }

    // Setters

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public void setTotalAircraftSeats(int totalAircraftSeats) {
        this.totalAircraftSeats = totalAircraftSeats;
    }

    public void setFlightMileage(int flightMileage) {
        this.flightMileage = flightMileage;
    }


    // Getters
    public int getFlightId() {
        return flightId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getAircraft() {
        return aircraft;
    }

    public int getTotalAircraftSeats() {
        return totalAircraftSeats;
    }

    public int getFlightMileage() {
        return flightMileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId == flight.flightId && totalAircraftSeats == flight.totalAircraftSeats && flightMileage == flight.flightMileage && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(aircraft, flight.aircraft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightNumber, aircraft, totalAircraftSeats, flightMileage);
    }
}