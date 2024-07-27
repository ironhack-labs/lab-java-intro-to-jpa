package com.ironhack.labweek304.service;

import com.ironhack.labweek304.model.Customer;
import com.ironhack.labweek304.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {


    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        log.info("Add customer {}", customer);
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer) {
        log.info("Update customer {}", customer);
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Integer customerId) {
        log.info("Delete customer {}", customerId);
        customerRepository.deleteById(customerId);
    }

    public Customer findById(Integer customerId) {
        log.info("Find customer {}", customerId);
        return customerRepository.findById(customerId).orElse(null);
    }
}
