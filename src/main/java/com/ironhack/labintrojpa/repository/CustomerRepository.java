package com.ironhack.labintrojpa.repository;

import com.ironhack.labintrojpa.enums.CustomerStatus;
import com.ironhack.labintrojpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCustomerNameContainingIgnoreCase (String customerName);
    List<Customer> findByCustomerStatus (CustomerStatus customerStatus);

}
