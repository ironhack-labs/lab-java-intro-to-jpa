package com.ironhack.labjpa.labjpa.repository;

import com.ironhack.labjpa.labjpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findFByFlightNumber(String flightNumber);
    List<Flight> findByFlightMileageGreaterThan(int flightMileage);

    //@Query("SELECT DISTINCT Flight.aircraftName FROM Flight WHERE Flight.aircraftName LIKE '%Boeing%'")
    //List<String> findAircraftNamesContainingBoeing();

    List<Flight> findAllByAircraftContaining(String word);

}
