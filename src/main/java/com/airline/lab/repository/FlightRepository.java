package com.airline.lab.repository;

import com.airline.lab.model.Customer;
import com.airline.lab.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    // 8. Write tests to verify your ability to find flights by flight number.
    List<Flight> findAllByFlightNumber(String flightNumber);

    // 9. Write tests to verify your ability to find aircraft with names containing "Boeing".
    List<Flight> findAllByAircraftLike(String aircraftLike);

    // 10. Write tests to verify your ability to find flights with a distance greater than 500 miles
    List<Flight> findAllByFlightMileageGreaterThan(int flightMileage);
}