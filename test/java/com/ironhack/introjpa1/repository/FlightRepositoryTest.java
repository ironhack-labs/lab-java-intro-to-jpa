package com.ironhack.introjpa1.repository;

import com.ironhack.introjpa1.models.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class FlightRepositoryTest {
    @Autowired
    private FlightRepository flightRepository;
    @BeforeEach
    void setUp() {
        flightRepository.deleteAll();
        Flight f1= new Flight("DL143","Boeing 747",400,135);
        Flight f2= new Flight("DL122","Airbus A330",236,4370);
        Flight f3= new Flight("DL222","Boeing777",264,1765);
        Flight f4= new Flight("DL53","Boeing 777",264,2078);

        flightRepository.saveAll(List.of(f1,f2,f3,f4));

    }

    @Test
    public void testCreateNewFlight() {

        Flight flight = new Flight("KL456", "Boeing 747", 300, 6000);

        // When
        Flight savedFlight = flightRepository.save(flight);

        // Then
        assertThat(savedFlight).isNotNull();
        assertThat(savedFlight.getFlightId()).isNotNull();
        assertThat(savedFlight.getFlightNumber()).isEqualTo("KL456");
        assertThat(savedFlight.getAircraft()).isEqualTo("Boeing 747");
        assertThat(savedFlight.getTotalAircraftSeats()).isEqualTo(300);
        assertThat(savedFlight.getFlightMileage()).isEqualTo(6000);

    }

    @Test
        void testFindBYFlightNumber() {
            List<Flight>flights= flightRepository.findByFlightNumber("DL143");
            assertThat(flights.get(0).getFlightNumber()).isEqualTo("DL143");
        }

    @Test
    void findByFlightMileageGreaterThan() {
        List<Flight> flights = flightRepository.findByFlightMileageGreaterThan(2000);
        assertThat(flights.get(0).getFlightMileage()).isGreaterThan(2000);
    }


    @Test
        public void testFindByAircraftContaining() {
            List<Flight> flights = flightRepository.findByAircraftContaining("Boeing");
            assertThat(flights.get(2).getAircraft()).contains("Boeing");
        }
}