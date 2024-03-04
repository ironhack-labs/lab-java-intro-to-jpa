package org.example.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "CustomerFlights")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_flight_id")
    private int customerFlightId;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "flight_number", referencedColumnName = "flight_number")
    private Flight flight;

    @Column(name = "total_customer_mileage")
    private int totalCustomerMileage;

    // Empty constructor for Hibernate
    public FlightBooking() {
    }

    // Parameterized constructor
    public FlightBooking(Customer customer, Flight flight, int totalCustomerMileage) {
        this.customer = customer;
        this.flight = flight;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public int getCustomerFlightId() {
        return customerFlightId;
    }

    public void setCustomerFlightId(int customerFlightId) {
        this.customerFlightId = customerFlightId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public int getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(int totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }
}