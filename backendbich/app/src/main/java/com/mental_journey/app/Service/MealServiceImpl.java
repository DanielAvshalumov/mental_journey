package com.mental_journey.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mental_journey.app.Model.Meal;
import com.mental_journey.app.Model.Physical;
import com.mental_journey.app.Repository.MealRepository;
import com.mental_journey.app.Repository.PhysicalRepository;

@Service
public class MealServiceImpl implements MealService{
    @Autowired
    MealRepository mealRepo;

    @Autowired 
    PhysicalRepository physicalRepo;

    @Override
    public ResponseEntity<Meal> create(Long id, Meal req) throws NotFoundException {
        Physical physical = physicalRepo.findById(id).orElseThrow(() -> new NotFoundException());
        req.setPhysical(physical);
        mealRepo.save(req);
        return new ResponseEntity<>(req,HttpStatus.OK);
    }


}
