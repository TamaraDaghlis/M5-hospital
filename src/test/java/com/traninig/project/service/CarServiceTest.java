package com.traninig.project.service;

import com.traninig.project.model.Car;
import com.traninig.project.repository.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarService carService;
    @MockBean
    private CarRepository carRepository;


    @Test
    void saveCar() {
        Car car = new Car(1234, "car");
        when(carRepository.save(any())).thenReturn(car);
        carService.saveCar(car);
        verify(carRepository,times(1)).save(any());
        Assertions.assertNotNull(car, "The saved car should not be null");
        assertEquals(1234, car.getPlateNumber());
    }

    @Test
    void getAllCars() {

        Car car1 = new Car(1234, "car");
        Car car2 = new Car(123,"van");
        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        when(carRepository.findAll()).thenReturn(carList);
        List<Car> carList1 =carService.getAllCars();
        assertEquals(carList1,carList);
        verify(carRepository,times(1)).findAll();

    }

    @Test
    void findById() {

        Car car = new Car(1234, "car");
        when(carRepository.findById(car.getPlateNumber())).thenReturn(Optional.ofNullable(car));
        assertThat(carService.findById(1234));
        verify(carRepository,times(1)).getById(1234);

    }

    @Test
    void updateCar() {



    }

    @Test
    void deleteCar() {
    }
}