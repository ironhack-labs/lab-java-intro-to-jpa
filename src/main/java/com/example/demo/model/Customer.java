package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //private static Integer idCounter = 0; // For auto-generating unique customerId
    private Integer customerId;
    private String customerName;
    private String customerStatus;
    private Integer totalCustomerMileage;


    // Empty constructor for Hibernate
   // public Customer() {
   //     this.customerId = ++idCounter; // Auto-generate unique customerId
    //}

    public Customer(){}

    // Parameterized constructor
    public Customer(String customerName, CustomerStatus customerStatus, int totalCustomerMileage) {
       // this.customerId = ++idCounter; // Auto-generate unique customerId
        this.customerName = customerName;
        this.customerStatus = customerStatus.toString();
        this.totalCustomerMileage = totalCustomerMileage;
    }

    // Getters and Setters
    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus.toString();
    }

    public int getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(int totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }
}
