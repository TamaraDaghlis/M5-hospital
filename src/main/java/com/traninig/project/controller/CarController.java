package com.traninig.project.controller;

import com.traninig.project.model.Car;
import com.traninig.project.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/add")
    public ResponseEntity<Car> addCar( @RequestBody Car car ) {
        carService.saveCar(car);
       return new ResponseEntity<>(car , HttpStatus.OK);
    }

    @GetMapping(" ")
    public ResponseEntity<List<Car>> getAllCars (){
        List<Car> cars=  carService.getAllCars();
         return new ResponseEntity<>(cars ,HttpStatus.OK ) ;
    }

    @GetMapping("/getById/{plateNumber}")
    public ResponseEntity<Car> getById (@PathVariable int plateNumber){
        Car car = carService.findById( plateNumber );
         return new ResponseEntity<>(car ,HttpStatus.OK);
    }

    @PutMapping("/update/{plateNumber}")
    public ResponseEntity<Car> updateCar(@PathVariable int plateNumber, @RequestBody Car car){
        carService.updateCar(plateNumber,car);
        return new ResponseEntity<>(car,HttpStatus.OK);

    }

    @DeleteMapping("/delete/{plateNumber}")
    public ResponseEntity<Map<String, Boolean>> deleteCar (@PathVariable int plateNumber){
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        carService.deleteCar(plateNumber );
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


}
