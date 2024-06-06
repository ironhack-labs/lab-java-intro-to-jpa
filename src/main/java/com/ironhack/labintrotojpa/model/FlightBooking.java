package com.ironhack.labintrotojpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.ref.Reference;

//Add public getter and setter methods for each variable in the FlightBooking class.
@Getter
@Setter
@Entity
public class FlightBooking {
    //Create a class called FlightBooking with the following variables:
    //
    //bookingId (integer): an auto-generated unique identifier, private member
    //Add foreign key constraints in the FlightBooking class to reference the customerId and flightId in the customers and flights tables respectively.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    //customerId (integer): private member
    @ManyToOne
    @JoinColumn(name = "customerId",referencedColumnName = "customerId")
    private  Customer customer;
    //flightId (integer): private member
    @ManyToOne
    @JoinColumn(name = "flightID", referencedColumnName = "flightId")
    private Flight flight;
    //Add an empty constructor to the FlightBooking class for Hibernate to create new instances of the class.
    public FlightBooking() {

    }
    //Add a parameterized constructor to the FlightBooking class that takes customerId and flightId as parameters.

    public FlightBooking(Customer customer, Flight flight) {
        this.customer = customer;
        this.flight = flight;
    }



}
