package com.ironhack.jpa.Repository;


import com.ironhack.jpa.Model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
    void findBy();
}
