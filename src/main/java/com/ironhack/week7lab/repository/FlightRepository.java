package com.ironhack.week7lab.repository;

import com.ironhack.week7lab.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String aircraftName);
    List<Flight> findByFlightMileageGreaterThan(Integer mileage);
}
