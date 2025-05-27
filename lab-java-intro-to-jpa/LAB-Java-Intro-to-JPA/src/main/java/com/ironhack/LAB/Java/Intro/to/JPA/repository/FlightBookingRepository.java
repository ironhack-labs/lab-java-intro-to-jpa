package com.ironhack.LAB.Java.Intro.to.JPA.repository;


import com.ironhack.LAB.Java.Intro.to.JPA.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {

}
