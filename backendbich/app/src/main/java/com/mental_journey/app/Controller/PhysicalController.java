package com.mental_journey.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mental_journey.app.Model.Physical;
import com.mental_journey.app.Service.PhysicalService;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/physical")
public class PhysicalController {
    
    @Autowired
    PhysicalService physicalService;

    @PostMapping("{id}")
    public ResponseEntity<Physical> createPhysical(@PathVariable Long id, @RequestBody Physical req) throws NotFoundException {
        
        return physicalService.create(id,req);
    }

}
