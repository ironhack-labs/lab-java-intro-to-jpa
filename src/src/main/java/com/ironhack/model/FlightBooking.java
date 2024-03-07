package com.ironhack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "FlightBooking")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer bookingId;

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "CustomerID", referencedColumnName = "ID")
    private Customer customer;

    @ManyToOne(targetEntity = Flight.class)
    @JoinColumn(name = "FlightID", referencedColumnName = "ID")
    private Flight flight;

    public FlightBooking() {
    }

    public FlightBooking(Customer customer, Flight flight) {
        this.customer = customer;
        this.flight = flight;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getCustomerId() {
        return this.customer.getCustomerId();
    }
}
