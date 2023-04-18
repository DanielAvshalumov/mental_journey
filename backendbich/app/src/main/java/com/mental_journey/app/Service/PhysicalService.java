package com.mental_journey.app.Service;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;

import com.mental_journey.app.Model.Physical;

public interface PhysicalService {
    public ResponseEntity<Physical> create(Long id, Physical req) throws NotFoundException;
    public ResponseEntity<Physical> get(Long id) throws NotFoundException;
    public ResponseEntity<Physical> update(Long id, Long mealId);
    public ResponseEntity<Physical> getUserPhysical(Long id) throws NotFoundException;
}
