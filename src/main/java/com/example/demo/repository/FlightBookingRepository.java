package com.example.demo.repository;

import com.example.demo.entity.FlightBooking;
import com.example.demo.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {
}
