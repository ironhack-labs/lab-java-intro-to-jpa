package com.ironhack.iabjpa.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "customers")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerName;

    private String customerStatus;
    private Integer totalCustomerMileage;

    // empty constructor
    public Customer() {}

    // Parameter constructor
    public Customer(String customerName, String customerStatus, int totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;

    }

    public Customer(String customerName, Customer customerStatus, int totalCustomerMileage) {

    }
}
