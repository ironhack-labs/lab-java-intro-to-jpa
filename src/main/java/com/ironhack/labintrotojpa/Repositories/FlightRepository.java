package com.ironhack.labintrotojpa.Repositories;

import com.ironhack.labintrotojpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContainingIgnoreCase(String aircraft);
    List<Flight> findByFlightMileageGreaterThanEqual(int mileage);
}
