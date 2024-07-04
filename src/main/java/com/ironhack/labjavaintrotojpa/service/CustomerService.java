package com.ironhack.labjavaintrotojpa.service;

import com.ironhack.labjavaintrotojpa.Enums.CustomerStatusEnum;
import com.ironhack.labjavaintrotojpa.model.Customer;
import com.ironhack.labjavaintrotojpa.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public void saveAll(List<Customer> customers) {
        customerRepository.saveAll(customers);
    }

    public void deleteAll() {
        customerRepository.deleteAll();
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(int id) {
        return customerRepository.findById(id).orElseThrow();
    }

    public List<Customer> findByName(String name) {
        return customerRepository.findByCustomerNameIgnoreCase(name);
    }

    public List<Customer> findByStatus(CustomerStatusEnum status) {
        return customerRepository.findByCustomerStatus(status);
    }

}
