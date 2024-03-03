package com.ironhacklab.intro_jpa.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="flight_id")
    private int flightId;
    @Column(name="flight_number")
    private UUID flightNumber;
    @Column(name="aircraft")
    private String aircraft;
    @Column(name="total_aircraft_seats")
    private int totalAircraftSeats;
    @Column(name="flight_mileage")
    private int flightMileage;
}
