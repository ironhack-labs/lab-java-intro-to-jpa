package com.ironhack.demo.repository;

import com.ironhack.demo.model.Customer;
import com.ironhack.demo.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByCustomerName(String customerName);
    Optional<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}
