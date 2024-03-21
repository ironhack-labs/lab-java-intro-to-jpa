package com.ironhack.labintrojpa.repository;

import com.ironhack.labintrojpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
    List<FlightBooking> findByCustomerId(int customerId);

    void deleteByCustomerId(int customerId);

}
