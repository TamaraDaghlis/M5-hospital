package com.traninig.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.traninig.project.model.Spot;

@Repository
public interface SpotRepository extends JpaRepository<Spot , Integer> {
}
