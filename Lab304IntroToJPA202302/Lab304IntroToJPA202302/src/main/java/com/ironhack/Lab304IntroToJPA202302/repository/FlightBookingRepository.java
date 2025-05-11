package com.ironhack.Lab304IntroToJPA202302.repository;

import com.ironhack.Lab304IntroToJPA202302.model.Customer;
import com.ironhack.Lab304IntroToJPA202302.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
}
