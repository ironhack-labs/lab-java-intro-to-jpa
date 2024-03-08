package com.ironhack.introJPA;

import com.ironhack.introJPA.model.Customer;
import com.ironhack.introJPA.model.CustomerStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroJpaApplication {

	public static void main(String[] args) {
	//	Customer customer = new Customer("PACO", CustomerStatus.Silver, 3000 );
	//	System.out.println(customer);
		SpringApplication.run(IntroJpaApplication.class, args);


	}


}
