package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

        // Finds customers by a fragment of their name
        List<Customer> findByCustomerNameContaining(String keyword);

        // Finds customers by their exact name and status
        List<Customer> findByCustomerNameAndCustomerStatus(String customerName, CustomerStatus customerStatus);

        // Finds all customers with total mileage greater than a provided number, ordered by customer name
        List<Customer> findByTotalCustomerMileageGreaterThanOrderByCustomerName(int mileage);
    }

