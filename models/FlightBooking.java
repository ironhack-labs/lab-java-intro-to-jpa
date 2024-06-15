package com.ironhack.introjpa1.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Entity
@Getter
@Setter
@Table

public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int bookingId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;
    //private int customerId;
    //private int flightId;

    public FlightBooking() {};

    public FlightBooking(int customerId, int flightId) {
        //this.customerId = customerId;
        //this.flightId = flightId;
    }
}
