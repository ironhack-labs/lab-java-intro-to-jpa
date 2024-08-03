package com.ironhack.week7lab.repository;

import com.ironhack.week7lab.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {}