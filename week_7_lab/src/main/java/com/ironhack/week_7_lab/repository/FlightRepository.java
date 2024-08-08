package com.ironhack.week_7_lab.repository;

import com.ironhack.week_7_lab.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface FlightRepository  extends JpaRepository<Flight, Long> {
}
