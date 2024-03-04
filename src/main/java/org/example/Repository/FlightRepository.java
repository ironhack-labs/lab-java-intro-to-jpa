package org.example.Repository;

import org.example.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByFlightNumber(String flightNumberToFind);

    List<Flight> findByAircraftContaining(String aircraftNameToFind);

    List<Flight> findByFlightMileageGreaterThan(int mileage);


}
