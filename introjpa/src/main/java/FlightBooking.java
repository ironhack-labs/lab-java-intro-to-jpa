public class FlightBooking {
    private int bookingId;
    private int customerId;
    private int flightId;

    // Empty constructor for Hibernate
    public FlightBooking() {
    }

    // Parameterized constructor
    public FlightBooking(int customerId, int flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    // Getter and setter methods
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
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