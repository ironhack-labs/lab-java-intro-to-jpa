package com.IronHack.Lab304.repository;


import com.IronHack.Lab304.model.Customer;
import com.IronHack.Lab304.model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //Consultar por nombre
    List<Customer> findAllByCustomerNameContaining (String customerN);

    //Consultar por Status

    List<Customer> findAllByCustomerStatus(CustomerStatus status);



}
