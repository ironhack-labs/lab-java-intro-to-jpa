package com.ironhack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    @Column(name = "name")
    private String customerName;
    @Column(name = "status")
    private CustomerStatus customerStatus;
    @Column(name = "total_mileage")
    private int totalCustomerMileage;

    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "emergency_contact_name")),
            @AttributeOverride(name = "phone", column = @Column(name = "emergency_contact_phone"))
    })
    @Embedded
    Contact emergencyContact;

    @Embedded
    Address permanentAddress;

    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "current_street")),
            @AttributeOverride(name = "number", column = @Column(name = "current_number")),
            @AttributeOverride(name = "city", column = @Column(name = "current_city")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "current_postal_code"))
    })
    @Embedded
    Address currentAddress;

    public Customer() {
    }

    public Customer(String customerName, CustomerStatus customerStatus, int totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
        this.customerStatus = customerStatus;
    }

    public int getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(int totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }
}
