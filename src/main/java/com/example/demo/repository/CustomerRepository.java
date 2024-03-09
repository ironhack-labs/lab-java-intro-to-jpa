package com.example.demo.repository;

import com.example.demo.model.Customer;
import com.example.demo.model.utils.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerName(String customerName);

    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);
}
