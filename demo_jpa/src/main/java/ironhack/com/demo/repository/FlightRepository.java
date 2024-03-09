package ironhack.com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ironhack.com.demo.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Optional<Flight> findFirstByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String flightNumber);
    List<Flight> findByFlightMileageGreaterThan(int Mileage);

}
