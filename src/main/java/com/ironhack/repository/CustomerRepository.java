package com.ironhack.repository;

import com.ironhack.model.Customer;
import com.ironhack.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findAllByCustomerName(String name);
    List<Customer> findAllByCustomerStatus(CustomerStatus status);
}
