package com.example.airlines.demo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "booking")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private int customerId;
    private int flightId;

    public FlightBooking(int bookingId, int customerId) {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightBooking that)) return false;
        return bookingId == that.bookingId && customerId == that.customerId && flightId == that.flightId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customerId, flightId);
    }

    public FlightBooking() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
