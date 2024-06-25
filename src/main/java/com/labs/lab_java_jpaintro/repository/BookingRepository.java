package com.labs.lab_java_jpaintro.repository;

import com.labs.lab_java_jpaintro.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
