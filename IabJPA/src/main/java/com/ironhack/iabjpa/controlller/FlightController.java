package com.ironhack.iabjpa.controlller;

import com.ironhack.iabjpa.model.Flight;
import com.ironhack.iabjpa.service.SpringJpaLab7Application;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor

public class FlightController {

    private final SpringJpaLab7Application flightService;

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight createdFlight = SpringJpaLab7Application(flight);
        return ResponseEntity.ok(createdFlight);
    }
    @GetMapping("/{flightId}")
    public Optional<Flight> getFlightById(@PathVariable Integer flightId) {
        return SpringJpaLab7Application.findFlightById(flightId);
    }
    @GetMapping("/search/{flightNumber}")
    public Flight getFlightByFlightNumber(@PathVariable String flightNumber) {
        return (Flight) SpringJpaLab7Application.findByFlightNumber(flightNumber);
    }
    @GetMapping("/search/{flightMileage}")
    public List<Flight> getFlightByFlightMileage(@PathVariable Integer flightMileage) {
        return SpringJpaLab7Application.findByFlightMileage(flightMileage);
    }
    @GetMapping("/search/aircraft")
    public List <Flight> getFlightByAircraft(@PathVariable String aircraft) {
        return SpringJpaLab7Application.findByAircraft(aircraft);
    }
    @DeleteMapping("/search/{flight}")
    public ResponseEntity<Flight> deleteFlight(@PathVariable Integer flightId) {
        SpringJpaLab7Application.deleteFlight(flightId);
        return ResponseEntity.noContent().build();
    }

}
