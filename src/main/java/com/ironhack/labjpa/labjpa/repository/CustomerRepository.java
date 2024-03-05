package com.ironhack.labjpa.labjpa.repository;

import com.ironhack.labjpa.labjpa.model.Customer;
import com.ironhack.labjpa.labjpa.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByCustomerName(String customerName);
    Optional<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}
