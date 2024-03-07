package com.ironhack.repository;

import com.ironhack.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Optional<Flight> findFlightByFlightNumber(String flightNumber);
    List<Flight> findAllByAircraftLike(String aircraft);
    List<Flight> findAllByFlightMileageGreaterThan(int flightMileage);
}
