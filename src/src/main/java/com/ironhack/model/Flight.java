package com.ironhack.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer flightId;

    @Column(name="FlightNumber")
    private String flightNumber;

    @Column(name="Aircraft")
    private String aircraft;

    @Column(name="Seats")
    private Integer totalAircraftSeats;

    @Column(name="Mileage")
    private Integer flightMileage;

    public Flight() {
    }

    public Flight(String flightNumber, String aircraft, Integer totalAircraftSeats, Integer flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

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

    public Integer getTotalAircraftSeats() {
        return totalAircraftSeats;
    }

    public void setTotalAircraftSeats(Integer totalAircraftSeats) {
        this.totalAircraftSeats = totalAircraftSeats;
    }

    public Integer getFlightMileage() {
        return flightMileage;
    }

    public void setFlightMileage(Integer flightMileage) {
        this.flightMileage = flightMileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight flight)) return false;
        return Objects.equals(flightId, flight.flightId) && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(aircraft, flight.aircraft) && Objects.equals(totalAircraftSeats, flight.totalAircraftSeats) && Objects.equals(flightMileage, flight.flightMileage);
    }
}
