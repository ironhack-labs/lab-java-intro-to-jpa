package com.ironhack.springjpalab7.repository;

import com.ironhack.springjpalab7.model.Flight;
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
