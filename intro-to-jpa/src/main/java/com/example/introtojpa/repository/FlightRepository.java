package com.example.introtojpa.repository;

import com.example.introtojpa.CustomerStatus;
import com.example.introtojpa.model.Customer;
import com.example.introtojpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Optional<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findAllByAircraftContains(String aircraftName);
    List<Flight> findAllByFlightMileageGreaterThan(int Mileage);

}