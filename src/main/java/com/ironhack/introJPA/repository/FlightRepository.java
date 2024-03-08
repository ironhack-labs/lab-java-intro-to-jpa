package com.ironhack.introJPA.repository;

import com.ironhack.introJPA.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContains(String aircraftName);
    List<Flight> findByFlightMileageGreaterThan(int Mileage);

    List<Flight> findByFlightMileageLessThan(int Mileage);

}
