package com.ironhack.LAB.Java.Intro.to.JPA.repository;

import com.ironhack.LAB.Java.Intro.to.JPA.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findFlightByFlightNumber(String flightNumber);
    List<Flight> findByAirCraftContainingIgnoreCase(String keyword);
    List<Flight> findByFlightMileageGreaterThan(Integer mileage);




}
