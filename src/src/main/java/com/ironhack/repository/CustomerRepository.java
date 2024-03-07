package com.ironhack.repository;

import com.ironhack.model.Customer;
import com.ironhack.model.components.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByCustomerName(String name);
    List<Customer> findAllByCustomerStatus(CustomerStatus status);
}
