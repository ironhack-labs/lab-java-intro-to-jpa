package com.ironhack.iabjpa;

import org.springframework.boot.SpringApplication;

public class TestIabJpaApplication {

    public static void main(String[] args) {
        SpringApplication.from(IabJpaApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
