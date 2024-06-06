package com.ironhack.labintrotojpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//Add public getter and setter methods for each variable in the Flight class.
@Getter
@Setter
@Entity
public class Flight {
    //Create a class called Flight with the following variables:
    //
    //flightId (integer): an auto-generated unique identifier, private member
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;
    //flightNumber (string): a unique identifier, private member

    private String flightNumber;
    //aircraft (string): private member
    private String aircraft;
    //totalAircraftSeats (integer): private member
    private int totalAircraftSeats;
    //flightMileage (integer): private member
    private int flightMileage;
    //Add an empty constructor to the Flight class for Hibernate to create new instances of the class.
    public Flight() {

    }
    //Add a parameterized constructor to the Flight class that takes flightNumber, aircraft, totalAircraftSeats and flightMileage as parameters.

    public Flight(String flightNumber, String aircraft, int totalAircraftSeats, int flightMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }

}
