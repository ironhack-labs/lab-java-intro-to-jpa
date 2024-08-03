package com.ironhack.week7lab.repository;

import com.ironhack.week7lab.enums.CustomerStatus;
import com.ironhack.week7lab.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByCustomerName(String customerName);
    List<Customer> findByCustomerStatus(CustomerStatus status);
}
