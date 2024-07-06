package com.ironhack.springjpalab7.service;


import com.ironhack.springjpalab7.model.Customer;
import com.ironhack.springjpalab7.model.CustomerStatus;
import com.ironhack.springjpalab7.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;


    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public List<Customer> findByCustomerName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }
    public List<Customer> findByCustomerStatus(CustomerStatus customerStatus) {
        return customerRepository.findByCustomerStatus(customerStatus);
    }
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
    public Optional<Customer> findCustomerById(Integer id) {
        return customerRepository.findById(id);
    }
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);

        }
    }

