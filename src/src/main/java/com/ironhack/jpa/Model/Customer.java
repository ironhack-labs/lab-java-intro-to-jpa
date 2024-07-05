package com.ironhack.jpa.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String customerName;

    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    private Integer totalMileage;

    // Empty constructor for Hibernate
    public Customer() {
    }

    // Parameterized constructor
    public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalMileage = totalCustomerMileage;
    }

    // Getter and Setter methods

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Integer getTotalCustomerMileage() {
        return totalMileage;
    }

    public void setTotalCustomerMileage(Integer totalCustomerMileage) {
        this.totalMileage = totalCustomerMileage;
    }
}
