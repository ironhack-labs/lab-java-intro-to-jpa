package com.ironhack.labweek304.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "flight_bookings")

public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookingId;

    @ManyToOne
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "fk_customer"))
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "flight_id", foreignKey = @ForeignKey(name = "fk_flight"))
    private Flight flight;

    public FlightBooking(String bookingId, int customerId, String flightId) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.flight = flight;
    }
}
