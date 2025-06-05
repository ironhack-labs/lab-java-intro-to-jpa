package com.example.airline.repositories;

import com.example.airline.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String text);
    List<Flight> findByFlightMileageGreaterThan(Integer mileage);
}
