package com.airline.lab.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId; // an auto-generated unique identifier, private member
    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_status")
    //@Enumerated(EnumType.ORDINAL)
    private CustomerStatus customerStatus; // representing an enum, private member

    @Column(name = "total_mileage")
    private int totalCustomerMileage; // private member

    // Empty constructor
    public Customer() {
    }

    // Parameterized constructor
    public Customer(String customerName, CustomerStatus customerStatus, int totalCustomerMileage) {
        setCustomerName(customerName);
        setCustomerStatus(customerStatus);
        setTotalCustomerMileage(totalCustomerMileage);
    }

    // Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public void setTotalCustomerMileage(int totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }


    // Getters
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public int getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && totalCustomerMileage == customer.totalCustomerMileage && Objects.equals(customerName, customer.customerName) && customerStatus == customer.customerStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerStatus, totalCustomerMileage);
    }
}