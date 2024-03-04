package org.example.Repository;

import org.example.Model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Integer> {
    // Define any custom queries if needed
}
