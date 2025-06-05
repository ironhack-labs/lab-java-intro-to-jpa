package com.ironhack.iabjpa.repository;

import com.ironhack.iabjpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByFlightMileage(Integer flightMileage);
    List<Flight> findByAircraft(String aircraft);
}
