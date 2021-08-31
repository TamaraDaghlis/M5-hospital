package com.traninig.project.service;

import com.traninig.project.model.Car;
import com.traninig.project.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;


    public Car saveCar(Car car) {
       return carRepository.save(car);

    }

    public List<Car> getAllCars (){
        return carRepository.findAll();
    }

    public Car findById (int plateNumber) {
        return carRepository.getById(plateNumber);
    }

    public Car updateCar (int plateNumber, Car car ){
        Car existingCar = carRepository.findById(plateNumber).orElse(null);
        existingCar.setCarType(car.getCarType());
        return carRepository.save(existingCar);
    }

    public void deleteCar (int plateNumber ){
        carRepository.deleteById(plateNumber);

    }


}
