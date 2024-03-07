package com.example.airline.repository;

import com.example.airline.model.Customer;
import com.example.airline.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByCustomerName(String customerName);
    List<Customer> findAllByCustomerStatus(CustomerStatus customerStatus);
}
