package com.backendAplication.app.service;

import com.backendAplication.app.Data.Cars;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarsServiceTest {

    @Autowired
    private CarsService carsService;

    @Test
    void addAndGetItem() {
        int numberOfCars = this.carsService.getNumberOfCars();
        Cars car = this.carsService.addItem(new Cars(numberOfCars + 1,"ferrari", "red", 200));
        assertEquals("ferrari", this.carsService.getItem(car.getId()).getName());
    }

    @Test
    void deleteLastItem() {
        Cars lastCar = this.carsService.getLastCar();
        int actualSize = this.carsService.getNumberOfCars();
        this.carsService.deleteItem(lastCar.getId());
        assertEquals(actualSize - 1, this.carsService.getNumberOfCars());
    }

    @Test
    void updateCar() {
        this.carsService.deleteAllItems();
        this.carsService.addItem(new Cars(1, "skoda", "red", 60));
        int id = this.carsService.getLastCar().getId();
        Cars car = new Cars(id, "audi", "green", 160);
        this.carsService.updateItem(car);
        assertEquals("audi", this.carsService.getItem(id).getName());
        assertEquals("green", this.carsService.getItem(id).getColor());
        assertEquals(160, this.carsService.getItem(id).getPower());
    }
}