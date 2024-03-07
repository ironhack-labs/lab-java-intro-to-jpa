package com.example.airline.repository;

import com.example.airline.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Integer> {
    List<Aircraft> findByAircraftContaining(String aircraft);
}
