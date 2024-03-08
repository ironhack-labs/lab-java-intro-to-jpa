package com.example.labjavaintrotojpa.repository;

import com.example.labjavaintrotojpa.model.Customer;
import com.example.labjavaintrotojpa.model.CustomerStatus;
import com.example.labjavaintrotojpa.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Flight findByFlightNumber(String flightNumber);
    List <Flight> findByAircraftContaining(String Aircraft);
    List <Flight> findByFlightMileageGreaterThan(int mileage);
}
