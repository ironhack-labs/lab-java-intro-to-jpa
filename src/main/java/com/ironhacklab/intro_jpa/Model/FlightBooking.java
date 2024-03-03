package com.ironhacklab.intro_jpa.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="FlightBooking")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName = "customer_id")
    private Customer customer;



    @ManyToOne
    @JoinColumn(name="flight_id", referencedColumnName = "flight_id")
    private Flight flight;
}
