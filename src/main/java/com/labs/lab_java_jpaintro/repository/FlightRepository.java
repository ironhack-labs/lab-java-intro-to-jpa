package com.labs.lab_java_jpaintro.repository;

import com.labs.lab_java_jpaintro.model.Customer;
import com.labs.lab_java_jpaintro.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String aircraftName);
    List<Flight> findByFlightMileageGreaterThan(Integer flightMileage);

}
