package com.ironhack.labjpa.Repository;

import com.ironhack.labjpa.model.Flight;
import com.ironhack.labjpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {

}
