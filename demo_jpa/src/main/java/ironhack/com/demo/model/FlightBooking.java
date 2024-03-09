package ironhack.com.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name="Reservations")
public class FlightBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int bookingId;
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "flight_id")
    private int flightId;
    public FlightBooking(){}

    public FlightBooking(int customerId, int flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
}
