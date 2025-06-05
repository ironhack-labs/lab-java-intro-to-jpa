package com.example.airline.repositories;

import com.example.airline.models.Customer;
import com.example.airline.enums.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerName(String name);
    List<Customer> findByCustomerStatus(CustomerStatus status);
}
