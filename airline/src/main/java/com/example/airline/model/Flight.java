package com.example.airline.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int flightId;
    private String flightNumber;
    private int flightMileage;

    public Flight(String flightNumber, int flightMileage) {
        this.flightNumber = flightNumber;
        this.flightMileage = flightMileage;
    }
}
