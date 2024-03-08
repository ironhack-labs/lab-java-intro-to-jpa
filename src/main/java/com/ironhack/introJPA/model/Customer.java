package com.ironhack.introJPA.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId ;
    @Column(name = "customer_name")
    private String customerName ;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_status")
    private CustomerStatus customerStatus;
    @Column(name = "total_customer_mileage")
    private Integer totalCustomerMileage;

    //default constructor:
    public Customer() {}

    public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        setCustomerName(customerName);
        setCustomerStatus(customerStatus);
        setTotalCustomerMileage(totalCustomerMileage);
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
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

    public Integer getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(Integer totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(customerName, customer.customerName) && Objects.equals(customerStatus, customer.customerStatus) && Objects.equals(totalCustomerMileage, customer.totalCustomerMileage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerStatus, totalCustomerMileage);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerStatus='" + customerStatus + '\'' +
                ", totalCustomerMileage=" + totalCustomerMileage +
                '}';
    }
}
