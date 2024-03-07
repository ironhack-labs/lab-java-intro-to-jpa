package com.example.airlines.demo.repository;

import com.example.airlines.demo.model.Customer;
import com.example.airlines.demo.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // new user
    Customer save(Customer customer);

    Customer findByCustomerName(String customerName);

    List<Customer> findByCustomerStatus(CustomerStatus status);

}
