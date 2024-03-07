package com.ironhack.demo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="flight_id")
    private Integer flightId;

    @Column(name="flight_number")
    private String flightNumber;

    @Column(name="aircraft")
    private String aircraft;

    @Column(name="total_aircraft_seats")
    private Integer totalAircraftSeats;

    @Column(name="flight_mileage")
    private Integer flightMileage;

    //Empty constructor
    public Flight(){}

    //Parametrized constructor
    public Flight(String flightNumber, String aircraft, Integer totalAircraftSeats, Integer flightMileage) {
        setFlightNumber(flightNumber);
        setAircraft(aircraft);
        setTotalAircraftSeats(totalAircraftSeats);
        setFlightMileage(flightMileage);
    }

    //Getters and setters
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

    //Equals & HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightId, flight.flightId) && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(aircraft, flight.aircraft) && Objects.equals(totalAircraftSeats, flight.totalAircraftSeats) && Objects.equals(flightMileage, flight.flightMileage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, flightNumber, aircraft, totalAircraftSeats, flightMileage);
    }

    //toString
    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightNumber='" + flightNumber + '\'' +
                ", aircraft='" + aircraft + '\'' +
                ", totalAircraftSeats=" + totalAircraftSeats +
                ", flightMileage=" + flightMileage +
                '}';
    }
}
