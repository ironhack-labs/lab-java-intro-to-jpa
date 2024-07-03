package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class CustomerRepositoryTest {

        private CustomerRepository customerTableRepository;

        // Create a new customer
        public Customer createCustomer(Customer customer) {
            return customerTableRepository.save(customer);
        }

        // Find customers whose names contain a specific keyword
        public List<Customer> findCustomersByNameContaining(String keyword) {
            return customerTableRepository.findByCustomerNameContaining(keyword);
        }

        // Find customers by their exact name and status
        public List<Customer> findCustomersByNameAndStatus(String customerName, CustomerStatus customerStatus) {
            return customerTableRepository.findByCustomerNameAndCustomerStatus(customerName, customerStatus);
        }

        // Find customers with mileage greater than a specific number, ordered by customer name
        public List<Customer> findCustomersByMileageGreaterThan(int mileage) {
            return customerTableRepository.findByTotalCustomerMileageGreaterThanOrderByCustomerName(mileage);
        }
    }
