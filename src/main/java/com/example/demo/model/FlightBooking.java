package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "flightBooking")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @OneToOne
    @JoinColumn(name = "customer", referencedColumnName = "customerId")
    private Customer customerId;

    @OneToOne
    @JoinColumn(name = "flight", referencedColumnName = "flightId")
   private Flight flightId;

    public FlightBooking(Customer customerId, Flight flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }


}