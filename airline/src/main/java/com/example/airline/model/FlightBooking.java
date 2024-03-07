package com.example.airline.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "customers_flights")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private int customerId;
    private int flightId;

    public FlightBooking(int customerId, int flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }
}
