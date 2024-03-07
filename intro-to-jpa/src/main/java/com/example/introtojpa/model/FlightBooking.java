package com.example.introtojpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customerFlightAssignment")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private int customerId;
    private int flightId;

    public FlightBooking() {
    }
    public FlightBooking(int customerId, int flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

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


    
    /*


Add foreign key constraints in the FlightBooking class to reference the customerId
and flightId in the customers and flights tables respectively.
     */

}
