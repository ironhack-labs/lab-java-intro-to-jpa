package com.example.airlines.demo.repository;

import com.example.airlines.demo.model.Customer;
import com.example.airlines.demo.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    // new user
    Flight save(Flight flight);

    Flight findByFlightNumber(String flightNumber);

    List<Flight> findByAircraft(String aircraft);

    List<Flight> findByFlightMileageGreaterThanEqual(Integer distance);


}
