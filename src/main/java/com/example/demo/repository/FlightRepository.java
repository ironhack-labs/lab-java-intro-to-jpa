package com.example.demo.repository;

import com.example.demo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumber(int flightNumber);
    List<Flight> findByAircraftContains(String aircraftName);
    List<Flight> findByFlightMileageGreaterThan(int nbMiles);
}
