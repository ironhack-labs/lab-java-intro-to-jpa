package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Component
    public static class PropertyPrinter implements CommandLineRunner {

        @Autowired
        private PropertyReader propertyReader;

        @Override
        public void run(String... args) {
            System.out.println(propertyReader.getMyCustomProperty());
        }
    }
}



