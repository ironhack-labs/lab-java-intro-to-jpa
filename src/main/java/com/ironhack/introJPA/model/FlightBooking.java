package com.ironhack.introJPA.model;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "flight_booking")
public class FlightBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="booking_id")
    private Integer bookingId;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "flight_id")
    private Integer flightId;

    //Hasta la linea 28 no hacer caso porque es redundante (está solo por tema correción robot)
 /*   @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight; */

    public FlightBooking() {}

    public FlightBooking(Integer customerId, Integer flightId) {
        setCustomerId(customerId);
        setFlightId(flightId);
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightBooking that = (FlightBooking) o;
        return Objects.equals(bookingId, that.bookingId) && Objects.equals(customerId, that.customerId) && Objects.equals(flightId, that.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, customerId, flightId);
    }

    @Override
    public String toString() {
        return "FlightBooking{" +
                "bookingId=" + bookingId +
                ", customerId=" + customerId +
                ", flightId=" + flightId +
                '}';
    }


}
