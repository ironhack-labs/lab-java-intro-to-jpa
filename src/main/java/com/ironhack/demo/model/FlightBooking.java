package com.ironhack.demo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "flight_booking")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_movements")
    private Integer bookingId;

    @Column(name="id_costumer")
    private Integer customerId;

    @Column(name="id_flight")
    private Integer flightId;

    @ManyToOne
    @JoinColumn(name="id_costumer", referencedColumnName="customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="id_flight", referencedColumnName="flight_id")
    private Flight flight;

    //Empty constructor
    public FlightBooking(){}

    //Parametrized constructor
    public FlightBooking(Integer bookingId, Integer customerId, Integer flightId) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.flightId = flightId;
    }

    //Getters and setters
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    //Equals & HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightBooking that = (FlightBooking) o;
        return Objects.equals(bookingId, that.bookingId) && Objects.equals(customerId, that.customerId) && Objects.equals(flightId, that.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customerId, flightId);
    }
}
