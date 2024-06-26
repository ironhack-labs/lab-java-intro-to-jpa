package com.IntroToJPA.Lab304IntroToJPA.repository;

import com.IntroToJPA.Lab304IntroToJPA.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {

}
