package com.ironhack.labjavaintrotojpa.repository;

import com.ironhack.labjavaintrotojpa.Enums.CustomerStatusEnum;
import com.ironhack.labjavaintrotojpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public List<Customer> findByCustomerNameIgnoreCase(String name);
    public List<Customer> findByCustomerStatus(CustomerStatusEnum status);

}
