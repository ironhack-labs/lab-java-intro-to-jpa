package org.example.repository;

import org.example.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String aircraftName);
    List<Flight> findByFlightMileageGreaterThan(int mileage);
}