package com.ironhack.demo.repository;

import com.ironhack.demo.model.Customer;
import com.ironhack.demo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Optional<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String aircraftName);
    List<Flight> findByFlightMileageGreaterThan(Integer mileage);

}
