package com.traninig.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.traninig.project.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository< Service , Integer>{
}
