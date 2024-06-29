import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    Flight findByFlightNumber(String flightNumber);
    List<Flight> findByAircraftContaining(String aircraftName);
    List<Flight> findByFlightMileageGreaterThan(int mileage);
}