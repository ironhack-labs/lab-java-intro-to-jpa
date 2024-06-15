package com.ironhack.introjpa1.repository;

import com.ironhack.introjpa1.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByFlightMileageGreaterThan(Integer flightMileage);
    List<Flight> findByAircraftContaining(String boeing);


}
