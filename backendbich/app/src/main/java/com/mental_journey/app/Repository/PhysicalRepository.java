package com.mental_journey.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mental_journey.app.Model.Physical;

@Repository
public interface PhysicalRepository extends JpaRepository<Physical, Long> {
    
}
