package com.airline.lab.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "bookings")
public class FlightBooking {
    @Id
    private int bookingId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id") // Foreign key constraint to reference the customerId in the customers table
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id") // Foreign key constraint to reference the flightId in the flights table
    private Flight flight;


    // Empty constructor
    public FlightBooking() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightBooking that = (FlightBooking) o;
        return bookingId == that.bookingId && Objects.equals(customer, that.customer) && Objects.equals(flight, that.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customer, flight);
    }

    // Parameterized constructor
//    public FlightBooking(int customerId, int flightId) {
//        this.customerId = customerId;
//        this.flightId = flightId;
//    }
//
//    // Setters
//    public void setBookingId(int bookingId) {
//        this.bookingId = bookingId;
//    }
//
//    public void setCustomerId(int customerId) {
//        this.customerId = customerId;
//    }
//
//    public void setFlightId(int flightId) {
//        this.flightId = flightId;
//    }
//
//
//    // Getters
//    public int getBookingId() {
//        return bookingId;
//    }
//
//    public int getCustomerId() {
//        return customerId;
//    }
//
//    public int getFlightId() {
//        return flightId;
//    }
}