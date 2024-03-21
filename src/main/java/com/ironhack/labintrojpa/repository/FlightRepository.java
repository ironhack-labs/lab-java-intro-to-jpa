package com.ironhack.labintrojpa.repository;

import com.ironhack.labintrojpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumberContaining(String flightNumber);

    List<Flight> findByFlightMileageGreaterThan(int flightMileage);
}
