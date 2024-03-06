package com.ironhack.demo.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @Column(name="id_flight")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;
    @Column(name="number")
    private String flightNumber;
    @Column(name="aircraft_name")
    private String aircraft;
    @Column(name="seats")
    private Integer totalAircraftSeats;
    @Column(name="flight_mileage")
    private Integer flightMileage;

    public Flight(){}

    public Flight(String flightNumber, String aircraft, Integer totalAircraftSeats, Integer flightMileage) {
        setFlightNumber(flightNumber);
        setAircraft(aircraft);
        setTotalAircraftSeats(totalAircraftSeats);
        setFlightMileage(flightMileage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight flight)) return false;
        return Objects.equals(getFlightNumber(), flight.getFlightNumber()) && Objects.equals(getAircraft(), flight.getAircraft()) && Objects.equals(getTotalAircraftSeats(), flight.getTotalAircraftSeats()) && Objects.equals(getFlightMileage(), flight.getFlightMileage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlightNumber(), getAircraft(), getTotalAircraftSeats(), getFlightMileage());
    }

    public Integer getFlightId() {
        return this.flightId;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraft() {
        return this.aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public Integer getTotalAircraftSeats() {
        return this.totalAircraftSeats;
    }

    public void setTotalAircraftSeats(Integer totalAircraftSeats) {
        this.totalAircraftSeats = totalAircraftSeats;
    }

    public Integer getFlightMileage() {
        return this.flightMileage;
    }

    public void setFlightMileage(Integer flightMileage) {
        this.flightMileage = flightMileage;
    }
}
