import java.util.concurrent.atomic.AtomicInteger;

public class Flight {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int flightId;
    private String flightNumber;
    private String aircraft;
    private int totalAircraftSeats;
    private int flightMileage;


    public Flight() {
        this.flightId = count.incrementAndGet();
    }


    public Flight(String flightNumber, String aircraft, int totalAircraftSeats, int flightMileage) {
        this.flightId = count.incrementAndGet();
        this.flightNumber = flightNumber;
        this.aircraft = aircraft;
        this.totalAircraftSeats = totalAircraftSeats;
        this.flightMileage = flightMileage;
    }


    public int getFlightId() {
        return flightId;
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
