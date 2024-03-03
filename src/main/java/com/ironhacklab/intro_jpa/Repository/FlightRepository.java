package com.ironhacklab.intro_jpa.Repository;

import com.ironhacklab.intro_jpa.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight findOneByFlightNumber(UUID flightNumber);

    List<Flight> findByAircraft(String aircraft);
    List<Flight> findByFlightMileageGreaterThan(int mileage);



}
