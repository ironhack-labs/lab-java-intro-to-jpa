package com.ironhack.week7lab.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Flight flight;

    public FlightBooking() {}

    public FlightBooking(Customer customer, Flight flight) {
        this.customer = customer;
        this.flight = flight;
    }
}
