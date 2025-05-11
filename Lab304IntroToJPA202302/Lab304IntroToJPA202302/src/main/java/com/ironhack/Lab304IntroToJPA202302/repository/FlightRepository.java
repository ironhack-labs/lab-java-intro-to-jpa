package com.ironhack.Lab304IntroToJPA202302.repository;

import com.ironhack.Lab304IntroToJPA202302.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String fragment);
    List<Flight> findByFlightMileageGreaterThan(Integer mileage);


}
