package com.ironhack.model;

import com.ironhack.model.components.CustomerStatus;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer customerId;
    @Column(name="Name")
    private String customerName;

    @Column(name="Status")
    private CustomerStatus customerStatus;

    @Column(name="TotalMileage")
    private Integer totalCustomerMileage;

    public Customer() {
    }

    public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }


    public Integer getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public void setTotalCustomerMileage(Integer totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(customerName, customer.customerName) && Objects.equals(customerStatus, customer.customerStatus) && Objects.equals(totalCustomerMileage, customer.totalCustomerMileage);
    }
}
