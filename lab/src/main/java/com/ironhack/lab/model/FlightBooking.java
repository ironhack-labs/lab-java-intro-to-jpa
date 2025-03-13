package com.ironhack.lab.model;

import jakarta.persistence.*;

@Entity
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    //private Integer flightId;
    //private Integer customerId;

    @OneToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "flightId", referencedColumnName = "flightId")
    private Flight flight;




    public FlightBooking() {
    }

    public FlightBooking(Integer customerId, Integer flightId) {
        this.flight = new Flight();
        this.flight.setFlightId(flightId);
        this.customer = new Customer();
        this.customer.setCustomerId(customerId);
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getCustomerId() {
        return customer.getCustomerId();
    }

    public void setCustomerId(Integer customerId) {
        this.customer = new Customer();
        this.customer.setCustomerId(customerId);
    }

    public Integer getFlightId() {
        return flight.getFlightId();
    }

    public void setFlightId(Integer flightId) {
        this.flight = new Flight();
        this.flight.setFlightId(flightId);
    }
}
