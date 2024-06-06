package com.ironhack.labjpa.Repository;

import com.ironhack.labjpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
List<Customer> findByCustomerName(String customerName);
List<Customer>findByCustomerStatus(String customerStatus);
}
