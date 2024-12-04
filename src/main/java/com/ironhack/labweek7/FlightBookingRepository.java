package com.ironhack.labweek7;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
