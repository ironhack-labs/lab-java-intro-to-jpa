package com.ironhack.labintrojpa.model;

import com.ironhack.labintrojpa.enums.CustomerStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
