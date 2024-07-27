package com.ironhack.labweek304.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "customers")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private int customerId;

    private String customerName;
    private CustomerStatus customerStatus;
    private int totalCustomerMileage;

    public Customer(String customerName, CustomerStatus customerStatus, int totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }


}
