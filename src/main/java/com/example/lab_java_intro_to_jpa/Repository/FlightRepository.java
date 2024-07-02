package com.example.lab_java_intro_to_jpa.Repository;

import com.example.lab_java_intro_to_jpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> FlightNumber(int flightNumber);
    List<Flight> findByAircraftContains(String aircraftName);
    List<Flight> findByFlightMileageGreaterThan(int nbMiles);

}