package com.ironhack.demo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Integer customerId;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="customer_status")
    @Enumerated(EnumType.STRING)
    private CustomerStatus customerStatus;

    @Column(name="total_customer_mileage")
    private Integer totalCustomerMileage;

    //Empty constructor
    public Customer(){}

    //Parametrized constructor
    public Customer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        setCustomerName(customerName);
        setCustomerStatus(customerStatus);
        setTotalCustomerMileage(totalCustomerMileage);
    }

    //Getters and setters
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

    //Equals & HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) && Objects.equals(customerName, customer.customerName) && customerStatus == customer.customerStatus && Objects.equals(totalCustomerMileage, customer.totalCustomerMileage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, customerStatus, totalCustomerMileage);
    }

    //toString
    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerStatus=" + customerStatus +
                ", totalCustomerMileage=" + totalCustomerMileage +
                '}';
    }
}
