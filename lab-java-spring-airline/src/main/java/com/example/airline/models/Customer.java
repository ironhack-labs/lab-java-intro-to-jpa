package com.example.airline.models;

import com.example.airline.enums.CustomerStatus;
import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;

    private String customerName;

    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    private Integer totalCustomerMileage;

    public Customer() {}

    public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    // Getters y setters...
}
