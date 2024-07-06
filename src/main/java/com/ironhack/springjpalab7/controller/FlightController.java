package com.ironhack.springjpalab7.controller;


import com.ironhack.springjpalab7.model.Flight;
import com.ironhack.springjpalab7.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight createdFlight = flightService.createFlight(flight);
        return ResponseEntity.ok(createdFlight);
        }
    @GetMapping("/{flightId}")
    public Optional<Flight> getFlightById(@PathVariable Integer flightId) {
       return flightService.findFlightById(flightId);
    }
    @GetMapping("/search/{flightNumber}")
    public Flight getFlightByFlightNumber(@PathVariable String flightNumber) {
        return (Flight) flightService.findByFlightNumber(flightNumber);
        }
        @GetMapping("/search/{flightMileage}")
    public List<Flight> getFlightByFlightMileage(@PathVariable Integer flightMileage) {
        return flightService.findByFlightMileage(flightMileage);
        }
        @GetMapping("/search/aircraft")
    public List <Flight> getFlightByAircraft(@PathVariable String aircraft) {
            return flightService.findByAircraft(aircraft);
        }
        @DeleteMapping("/search/{flight}")
    public ResponseEntity<Flight> deleteFlight(@PathVariable Integer flightId) {
        flightService.deleteFlight(flightId);
        return ResponseEntity.noContent().build();
        }

}

