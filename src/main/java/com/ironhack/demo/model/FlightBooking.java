package com.ironhack.demo.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "airline")
public class FlightBooking {

    @Id
    @Column(name="id_movements")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    @Column(name="id_costumer")
    private Integer customerId;
    @Column(name="id_flight")
    private Integer flightId;

    public FlightBooking(){}

    public FlightBooking(Integer customerId, Integer flightId) {
        setCustomerId(customerId);
        setFlightId(flightId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightBooking that)) return false;
        return Objects.equals(getCustomerId(), that.getCustomerId()) && Objects.equals(getFlightId(), that.getFlightId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getFlightId());
    }

    public Integer getBookingId() {
        return this.bookingId;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getFlightId() {
        return this.flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }
}
