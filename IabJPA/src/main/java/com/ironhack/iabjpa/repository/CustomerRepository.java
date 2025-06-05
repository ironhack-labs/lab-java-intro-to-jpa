package com.ironhack.iabjpa.repository;

import com.ironhack.iabjpa.model.Customer;
import com.ironhack.iabjpa.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);
    List<Customer> findByCustomerName(String customerName);
}
