package com.IronHack.Lab304.model;


import jakarta.persistence.*;

@Entity
public class FlightBooking {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer bookingID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "flightID")
    private Flight flight;



    //empty constructor

    public FlightBooking() {
    }

    //parametric constructor


    public FlightBooking(Customer customer, Flight flight) {
        this.customer = customer;
        this.flight = flight;
    }
}
