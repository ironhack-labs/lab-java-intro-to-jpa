package com.ironhack.labintrotojpa.Repositories;

import com.ironhack.labintrotojpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
   List<Customer> findByCustomerName(String customerName);
   List<Customer> findByCustomerStatus(String customerStatus);
}

