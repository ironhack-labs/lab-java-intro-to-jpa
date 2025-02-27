package com.ironhack.lab304.repository;

import com.ironhack.lab304.model.Customer;
import com.ironhack.lab304.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByCustomerName(String customerName);
    List<Customer> findAllByCustomerStatus(CustomerStatus customerStatus);
}
