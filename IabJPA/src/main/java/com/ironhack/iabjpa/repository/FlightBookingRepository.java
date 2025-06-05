package com.ironhack.iabjpa.repository;

import com.ironhack.iabjpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
    List<FlightBooking> findByFlightId(int flightId);
    List<FlightBooking> findByCustomerId(int customerId);
}
