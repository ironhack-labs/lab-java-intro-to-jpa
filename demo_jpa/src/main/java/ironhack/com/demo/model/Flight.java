package ironhack.com.demo.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "Flights_Info")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int flightId;
    @Column(name="flight_number")
    private String flightNumber;
    @Column(name="aircraft")
    private String aircraft;

    @Column(name="total_aircraft_seats")
    private int totalAircraftSeats;

    @Column(name="mileage")
    private int flightMileage;

    public Flight(){}

    public Flight(String flightNumber, String aircraft, int totalAircraftSeats, int fligthMileage) {
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = fligthMileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return totalAircraftSeats == flight.totalAircraftSeats && flightMileage == flight.flightMileage && Objects.equals(flightNumber, flight.flightNumber) && Objects.equals(aircraft, flight.aircraft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightNumber, aircraft, totalAircraftSeats, flightMileage);
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }

    public int getTotalAircraftSeats() {
        return totalAircraftSeats;
    }

    public void setTotalAircraftSeats(int totalAircraftSeats) {
        this.totalAircraftSeats = totalAircraftSeats;
    }

    public int getFlightMileage() {
        return flightMileage;
    }

    public void setFlightMileage(int flightMileage) {
        this.flightMileage = flightMileage;
    }
}
