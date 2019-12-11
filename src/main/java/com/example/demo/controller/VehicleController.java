package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelAndRepo.VehicleModel;
import com.example.demo.modelAndRepo.VehicleRepo;
import com.example.demoException.RecordNotFoundException;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	@Autowired
	@Qualifier("p")
	VehicleRepo repo;

    @GetMapping("/qq")
    public ResponseEntity<List<VehicleModel>> getAllEmployees() {
        List<VehicleModel> list = repo.findAll();
        return new ResponseEntity<List<VehicleModel>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    
    @PostMapping
    public ResponseEntity<VehicleModel> createVehicle(VehicleModel vehicle)
                                                    throws RecordNotFoundException {    	
		   return new ResponseEntity<VehicleModel>(repo.save(vehicle), new HttpHeaders(), HttpStatus.OK);
    }
 
    @PutMapping
    public ResponseEntity<VehicleModel> updateWholeVehicle(Long id,VehicleModel v)
            throws RecordNotFoundException { 
    	 return new ResponseEntity<VehicleModel>(( repo.findById(id).map(vehicle -> {
    		 vehicle.setName(v.getName());
             return repo.save(vehicle);
         }).orElseThrow(()->new RecordNotFoundException())), new HttpHeaders(), HttpStatus.OK); 
   	}
    
}
