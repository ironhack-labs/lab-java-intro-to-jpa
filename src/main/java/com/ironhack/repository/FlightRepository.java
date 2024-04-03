package com.ironhack.repository;

import com.ironhack.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findAllByFlightNumber(String flightNumber);
    List<Flight> findByFlightMileageGreaterThan(int flightMileage);
    List<Flight> findByAircraftContaining(String aircraft);

}
