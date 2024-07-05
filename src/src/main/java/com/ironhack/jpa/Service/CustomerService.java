package com.ironhack.jpa.Service;

import com.ironhack.jpa.Model.Customer;
import com.ironhack.jpa.Model.CustomerStatus;
import com.ironhack.jpa.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllStudents() {
        return customerRepository.findAll();
    }

    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public List<Customer> getCustomersByName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }
    public List<Customer> getCustomersByStatus(CustomerStatus customerStatus) {
        return customerRepository.findByCustomerStatus(customerStatus);
    }
}
