package com.labs.lab_java_jpaintro.model;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flightId;


    public Booking() {
    }



    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customerId;
    }

    public void setCustomer(Customer customerId) {
        this.customerId = customerId;
    }

    public Flight getFlight() {
        return flightId;
    }

    public void setFlight(Flight flightId) {
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", customer=" + customerId +
                ", flight=" + flightId +
                '}';
    }
}