package com.ironhack.introjpa1.repository;

import com.ironhack.introjpa1.models.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
