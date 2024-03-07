package com.example.airline.repository;

import com.example.airline.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findByFlightNumber(String flightNumber);
    List<Flight> findByFlightMileageGreaterThan(int miles);

}
