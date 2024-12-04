package com.ironhack.labweek7;

import jakarta.persistence.*;

@Entity
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "flightId", nullable = false)
    private Flight flight;

    // Empty constructor for Hibernate
    public FlightBooking() {
    }

    // Parameterized constructor
    public FlightBooking(Customer customer, Flight flight) {
        this.customer = customer;
        this.flight = flight;
    }

    // Getters and setters
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}

