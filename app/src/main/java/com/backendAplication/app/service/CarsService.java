package com.backendAplication.app.service;

import com.backendAplication.app.Data.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backendAplication.app.repository.CarsRepository;

import java.util.List;


@Service
public class CarsService {
    @Autowired
    private CarsRepository repository;

    /**
     *
     * @param car auto, ktoré chceme pridať do tabuľky
     * @return vracia pridané auto
     */
    public Cars addItem(Cars car) {
        return this.repository.save(car);
    }

    /**
     *
     * @param id identifikátor auta, ktoré chcem vymazať
     */
    public void deleteItem(int id) {
        this.repository.deleteById(id);
    }

    /**
     *
     * @param id identifikátor auta, ktoré hľadáme
     * @return vracia auto, ktoré hľadáme
     */
    public Cars getItem(int id) {
        return this.repository.findById(id).orElse(null);
    }

    /**
     *
     * @param car auto s daným identifikátorom, ktoré sa updatuje
     * @return updatnuté auto
     */
    public Cars updateItem(Cars car) {
        Cars existingItem = this.repository.findById(car.getId()).orElse(null);
        if (existingItem != null) {
            existingItem.setColor(car.getColor());
            existingItem.setName(car.getName());
            existingItem.setPower(car.getPower());
            return this.repository.save(existingItem);
        }
        return this.repository.save(car);
    }

    /**
     *
     * @return počet áut v tabuľke
     */
    public int getNumberOfCars() {
        return this.repository.findAll().size();
    }
    public void deleteAllItems() {
        this.repository.deleteAll();

    }
    public Cars getLastCar() {
        List<Cars> cars= this.repository.findAll();
        return cars.get(cars.size() - 1);
    }
}
