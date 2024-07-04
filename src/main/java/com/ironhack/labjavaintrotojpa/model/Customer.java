package com.ironhack.labjavaintrotojpa.model;

import com.ironhack.labjavaintrotojpa.Enums.CustomerStatusEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_status")
    @Enumerated(EnumType.STRING)
    private CustomerStatusEnum customerStatus;

    @Column(name = "total_customer_mileage")
    private int totalCustomerMileage;

    public Customer(String customerName, CustomerStatusEnum customerStatus, int totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

}
