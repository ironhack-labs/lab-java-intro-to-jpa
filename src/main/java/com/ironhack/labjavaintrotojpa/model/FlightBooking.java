package com.ironhack.labjavaintrotojpa.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "flight_bookings")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flightId;

    public FlightBooking(Customer customerId, Flight flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }
}
