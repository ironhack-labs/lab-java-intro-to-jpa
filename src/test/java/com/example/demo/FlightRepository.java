package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumber(String flightNumber);

    List<Flight> findByAircraftContaining(String keyword);

    List<Flight> findByFlightMileageGreaterThan(Integer mileage);
}