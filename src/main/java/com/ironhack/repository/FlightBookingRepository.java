package com.ironhack.repository;

import com.ironhack.model.Customer;
import com.ironhack.model.Flight;
import com.ironhack.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {

    List<FlightBooking> findAllByCustomerId(Customer customer);
    List<FlightBooking> findAllByFlightId(Flight flight);
}
