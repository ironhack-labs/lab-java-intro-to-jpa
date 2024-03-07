package com.example.airlines.demo.model;

import com.example.airlines.demo.repository.CustomerRepository;
import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_status")
    private CustomerStatus customerStatus;
    @Column(name = "total_mileage")
    private int totalCustomerMileage;

    public Customer(String customerName, CustomerStatus status, int totalCustomerMileage) {
        setCustomerName(customerName);
        setCustomerStatus(status);
        setTotalCustomerMileage(totalCustomerMileage);
    }

    public Customer() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = Integer.parseInt(customerId);
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
        this.customerStatus = CustomerStatus.valueOf(customerStatus.name());
    }

    public Integer getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(Integer totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }
}
