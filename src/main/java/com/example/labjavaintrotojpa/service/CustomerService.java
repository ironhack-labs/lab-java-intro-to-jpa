package com.example.labjavaintrotojpa.service;

import com.example.labjavaintrotojpa.model.Customer;
import com.example.labjavaintrotojpa.model.CustomerStatus;
import com.example.labjavaintrotojpa.repository.CustomerRepository;
import com.example.labjavaintrotojpa.util.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createNewCustomer(String customerName, CustomerStatus customerStatus, Integer totalCustomerMileage) {
        Customer customer = new Customer(customerName, customerStatus, totalCustomerMileage);
        return customerRepository.save(customer);
    }
    public List<Customer> findCustomersByName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }
    public List<Customer> findCustomerByStatus(CustomerStatus status) {
        return customerRepository.findByCustomerStatus(status);
    }
}

