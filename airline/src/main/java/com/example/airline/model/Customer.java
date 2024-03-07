package com.example.airline.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int customerId;
    private String customerName;
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;
    private int totalCustomerMileage;

    public Customer(String customerName, CustomerStatus customerStatus, int totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }
}