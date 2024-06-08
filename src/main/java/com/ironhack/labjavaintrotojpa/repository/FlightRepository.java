package com.ironhack.labjavaintrotojpa.repository;

import com.ironhack.labjavaintrotojpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
    // Custom query methods can be added if needed in the future
}