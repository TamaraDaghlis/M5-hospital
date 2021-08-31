package com.traninig.project.service;

import com.traninig.project.model.Car;
import com.traninig.project.model.Customer;
import com.traninig.project.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Customer registerCustomer (Customer customer){
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(customer.getEmail() != null)
            customer.setEmail(customer.getEmail().toLowerCase()) ;
        if(!pattern.matcher(customer.getEmail()).matches())
            throw new RuntimeException("Invalid email format");
         Customer count = customerRepository.getCountByEmail( customer.getEmail());
        if(  count != null )
            throw new RuntimeException("Email already in used");
        return customerRepository.save(customer);
    }

    public Customer validateCustomer(String email , String password ){
        if(email != null) email = email.toLowerCase();
        return customerRepository.findByEmailAndPassword(email, password);
    }

    public List<Customer> getAllCustomers (){
        return customerRepository.findAll();
    }









}
