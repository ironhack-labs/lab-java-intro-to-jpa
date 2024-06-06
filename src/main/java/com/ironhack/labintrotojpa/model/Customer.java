package com.ironhack.labintrotojpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
//Add public getter and setter methods for each variable in the Customer class.

@Getter
@Setter
@Entity
public class Customer {
    //Create a class called Customer with the following variables:
    //
    //customerId (integer): an auto-generated unique identifier, private member
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    //customerName (string): private member
    private String customerName;
    //customerStatus (string): representing an enum, private member
    private String customerStatus;
    //totalCustomerMileage (integer): private member
    private int totalCustomerMileage;
    //Add an empty constructor to the Customer class for Hibernate to create new instances of the class.
    public Customer(){

    }
    //Add a parameterized constructor to the Customer class that takes customerName, customerStatus and totalCustomerMileage as parameters.
    public Customer(String customerName, String customerStatus, int totalCustomerMileage) {
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }
}
