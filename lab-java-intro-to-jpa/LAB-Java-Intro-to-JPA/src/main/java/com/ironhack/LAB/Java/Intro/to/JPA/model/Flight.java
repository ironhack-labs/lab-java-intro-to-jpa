package com.ironhack.LAB.Java.Intro.to.JPA.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;
    private String flightNumber;
    private String airCraft;
    private Integer totalAirCraftSeats;
    private Integer flightMileage;
    private Integer customerId;

    public Flight() {
    }

    public Flight(Integer costumerId) {
        this.customerId = costumerId;
    }

    public Flight(String flightNumber, String airCraft, Integer totalAirCraftSeats, Integer flightMileage, Integer customerId) {
        this.flightNumber = flightNumber;
        this.airCraft = airCraft;
        this.totalAirCraftSeats = totalAirCraftSeats;
        this.flightMileage = flightMileage;
        this.customerId = customerId;
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

    public String getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(String airCraft) {
        this.airCraft = airCraft;
    }

    public Integer getTotalAirCraftSeats() {
        return totalAirCraftSeats;
    }

    public void setTotalAirCraftSeats(Integer totalAirCraftSeats) {
        this.totalAirCraftSeats = totalAirCraftSeats;
    }

    public Integer getFlightMileage() {
        return flightMileage;
    }

    public void setFlightMileage(Integer flightMileage) {
        this.flightMileage = flightMileage;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", flightNumber='" + flightNumber + '\'' +
                ", airCraft='" + airCraft + '\'' +
                ", totalAirCraftSeats=" + totalAirCraftSeats +
                ", flightMileage=" + flightMileage +
                ", costumerId=" + customerId +
                '}';
    }
}
