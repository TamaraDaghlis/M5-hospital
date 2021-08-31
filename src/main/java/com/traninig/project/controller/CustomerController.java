package com.traninig.project.controller;


import com.traninig.project.model.Customer;
import com.traninig.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer (@RequestBody Customer customer){
        customerService.registerCustomer(customer );
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<Customer> loginUser(@RequestBody Customer customer) {
        String email = customer.getEmail();
        String password = customer.getPassword();
        customerService.validateCustomer(email, password );
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @GetMapping(" ")
    public ResponseEntity<List<Customer>> getAllCustomers (){
       List<Customer> customers =  customerService.getAllCustomers();
       return new ResponseEntity<>(customers,HttpStatus.OK);
    }
}





