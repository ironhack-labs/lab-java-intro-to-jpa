package com.ironhack.labjavaintrotojpa.repository;

import com.ironhack.labjavaintrotojpa.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {

}
