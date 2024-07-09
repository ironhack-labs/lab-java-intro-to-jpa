package com.example.demo.model;

import jakarta.persistence.*;


@Entity
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @Column(nullable = false)
    private Integer customerId;

    @Column(nullable = false)
    private Integer flightId;

    // Empty constructor
    public FlightBooking() {}

    // Parameterized constructor
    public FlightBooking(int customerId, int flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    // Getter and Setter methods
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
}

