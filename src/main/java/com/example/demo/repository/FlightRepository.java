package com.example.demo.repository;

import com.example.demo.entity.Flight;
import com.example.demo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftNameContaining(String name);

