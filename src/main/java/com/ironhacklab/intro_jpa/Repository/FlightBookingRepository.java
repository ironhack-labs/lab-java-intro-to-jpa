package com.ironhacklab.intro_jpa.Repository;

import com.ironhacklab.intro_jpa.Model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
