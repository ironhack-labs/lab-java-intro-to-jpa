package com.ironhack.week_7_lab.demo;


import com.ironhack.week_7_lab.model.Customer;
import com.ironhack.week_7_lab.model.CustomerStatus;
import com.ironhack.week_7_lab.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataLoader implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        // Create and save customers
        Customer customer1 = new Customer("Agustine Riviera", CustomerStatus.GOLD, 115235);
        Customer customer2 = new Customer("Alaina Sepulvida", CustomerStatus.NONE, 6008);
        Customer customer3 = new Customer("Tom Jones", CustomerStatus.GOLD, 205767);
        Customer customer4 = new Customer("Sam Rio", CustomerStatus.NONE, 2653);
        Customer customer5 = new Customer("Jessica James", CustomerStatus.SILVER, 127656);

        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customer4);
        customerRepository.save(customer5);
    }
}

