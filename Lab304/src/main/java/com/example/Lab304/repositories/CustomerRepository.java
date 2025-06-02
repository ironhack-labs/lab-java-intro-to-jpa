package com.example.Lab304.repositories;


import com.example.Lab304.classes.Customer;
import com.example.Lab304.enums.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByCustomerName(String name);
    List<Customer> findByCustomerStatus(CustomerStatus status);
}
