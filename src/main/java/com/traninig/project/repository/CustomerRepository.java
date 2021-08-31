package com.traninig.project.repository;

import com.traninig.project.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer , Integer>  {

    public Customer getCountByEmail (String email);

    public Customer findByEmailAndPassword (String email, String password);
}
