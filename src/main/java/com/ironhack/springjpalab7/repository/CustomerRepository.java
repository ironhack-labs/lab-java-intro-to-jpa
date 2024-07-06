package com.ironhack.springjpalab7.repository;

import com.ironhack.springjpalab7.model.Customer;
import com.ironhack.springjpalab7.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerStatus(CustomerStatus customerStatus);
    List<Customer> findByCustomerName(String customerName);
}
