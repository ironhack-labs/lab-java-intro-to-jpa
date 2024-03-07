package com.example.airline.repository;

import com.example.airline.model.Aircraft;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AircraftRepositoryTest {

    @Autowired
    private AircraftRepository aircraftRepo;

    private Aircraft a1;
    private Aircraft a2;
    private List<Aircraft> aircraftList;

    @BeforeEach
    public void setUp() {
        a1 = new Aircraft("Airbus A330", 300);
        aircraftRepo.save(a1);

        a2 = new Aircraft("Boeing 777", 500);
        aircraftRepo.save(a2);
    }

    @AfterEach
    public void tearDown() {
        aircraftRepo.deleteAll();
    }

    @Test
    public void findAllTest() {
        aircraftList = aircraftRepo.findAll();
        assertEquals(2, aircraftList.size());
    }

    @Test
    public void findByAircraftContaining() {
        aircraftList = aircraftRepo.findByAircraftContaining("Boeing");
        assertEquals(1, aircraftList.size());
    }

}