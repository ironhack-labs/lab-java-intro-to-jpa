package com.ironhack.labweek304.repository;

import com.ironhack.labweek304.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
