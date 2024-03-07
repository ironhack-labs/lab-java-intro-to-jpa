package com.example.airline.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "aircrafts")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int aircraftId;
    private String aircraft;
    private int totalAircraftSeats;

    public Aircraft(String aircraft, int totalAircraftSeats) {
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
    }

}
