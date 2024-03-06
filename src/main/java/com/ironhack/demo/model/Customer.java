package com.ironhack.demo.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name="id_customer")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column(name="name")
    private String customerName;
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;
    @Column(name="customer_mileage")
    private Integer totalCustomerMileage;

    public Customer(){}

    public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        setCustomerName(customerName);
        setCustomerStatus(customerStatus);
        setTotalCustomerMileage(totalCustomerMileage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return Objects.equals(getCustomerName(), customer.getCustomerName()) && Objects.equals(getCustomerStatus(), customer.getCustomerStatus()) && Objects.equals(getTotalCustomerMileage(), customer.getTotalCustomerMileage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerName(), getCustomerStatus(), getTotalCustomerMileage());
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public CustomerStatus getCustomerStatus() {
        return this.customerStatus;
    }

    public Integer getTotalCustomerMileage() {
        return this.totalCustomerMileage;
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
}
