package com.IronHack.Lab304.repository;

import com.IronHack.Lab304.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    //Consultar por numerto de vuelo
    List<Flight> findAllByFlightNumberContaining (String flightN);


    //Buscar por Boeing
    List<Flight> findByAircraftContaining (String aircraftType);

    //Buscar vuelos de mas de 500     private Integer flightMileage;

    List<Flight> findByFlightMileageGreaterThan (Integer flightMileage);
}
