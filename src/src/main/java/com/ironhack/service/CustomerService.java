package com.ironhack.service;

import com.ironhack.model.Customer;
import com.ironhack.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

//    public List<Customer> getAllCustomersByCustomerStatus(CustomerStatus status) {
//        return customerRepository.findAllByCustomerStatus(status);
//    }

    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}

