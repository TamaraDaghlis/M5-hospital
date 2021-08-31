package com.traninig.project.controller;


import com.traninig.project.model.Car;
import com.traninig.project.model.Service;
import com.traninig.project.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping ("/api/car/{plateNumber}/service")
public class ServiceController {

    @Autowired
    ServiceService serviceService;

    @PostMapping("/add")
    public ResponseEntity<Service> addCar( @RequestBody Service service  ) {
        serviceService.saveService(service);
        return new ResponseEntity<>(service , HttpStatus.OK);

    }

    @GetMapping(" ")
    public ResponseEntity<List<Service>> getAllServices (){
        List<Service> services=  serviceService.getAllservices();
        return new ResponseEntity<>(services ,HttpStatus.OK ) ;
    }

    @GetMapping("/getById/{serviceID}")
    public  ResponseEntity<Service> getById (@PathVariable int serviceID ){
       Service service = serviceService.findById( serviceID );
        return new ResponseEntity<>(service ,HttpStatus.OK);

    }

    @PutMapping("/update/{serviceID}")
    public ResponseEntity<Service> updateService(  @PathVariable int serviceID, @RequestBody Service service){
       serviceService.updateService(serviceID,service);
       return new ResponseEntity<>(service,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{serviceID}")
    public ResponseEntity<Map<String, Boolean>> deleteService ( @PathVariable int serviceID ){
        Map<String, Boolean> map = new HashMap<>();
        map.put("success", true);
        serviceService.deleteService(serviceID );
        return new ResponseEntity<>(map, HttpStatus.OK);

    }


}
