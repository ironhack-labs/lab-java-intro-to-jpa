package com.ironhack.labjpa.Repository;

import com.ironhack.labjpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumber(String flightNumber);
    List<Flight>findByAircraftContainingIgnoreCase(String aircraft);
    List<Flight>findByFlightMileageGreaterThanEqual(int flightMileage);
}
