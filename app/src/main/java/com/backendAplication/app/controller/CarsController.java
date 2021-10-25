package com.backendAplication.app.controller;

import com.backendAplication.app.Data.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.backendAplication.app.service.CarsService;

@RestController
public class CarsController {
    @Autowired
    private CarsService service;

    /**
     *
     * @param id identifikátor
     * @return referencia na inštanciu auta s hľadaným identifikátorom
     */
    @GetMapping("/getCar/{id}")
    public Cars getCar(@PathVariable int id) {
        return service.getItem(id);
    }

    /**
     *
     * @param car auto, ktoré chceme pridať
     */
    @PostMapping("/newCar")
    public void postCar(@RequestBody Cars car) {
        service.addItem(car);
    }

    /**
     *
     * @param car auto, ktoré chceme updatnúť. Vykoná sa podľa definovaného identifikátora
     * @return updatnuté auto
     */
    @PutMapping("/updateCar")
    public Cars updateCar(@RequestBody Cars car) {
        return service.updateItem(car);
    }

    /**
     *
     * @param id identifikátor auta, ktoré sa vymaže
     */
    @DeleteMapping("/deleteCar/{id}")
    public void deleteCar(@PathVariable int id) {
        service.deleteItem(id);
    }
}
