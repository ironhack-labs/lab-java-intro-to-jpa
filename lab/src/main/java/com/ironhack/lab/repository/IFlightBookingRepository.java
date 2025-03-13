package com.ironhack.lab.repository;

import com.ironhack.lab.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlightBookingRepository extends JpaRepository<FlightBooking, Integer> {

}
