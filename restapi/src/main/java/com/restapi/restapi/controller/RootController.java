package com.restapi.restapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restapi.restapi.modal.HospitalModal;
import com.restapi.restapi.services.Service;

@RestController
public class RootController {
    
    @Autowired
    private Service service;

    @GetMapping("/home")
    public String test(){

        return "Test Method";

    }

    @GetMapping("/name")
    public ResponseEntity<List<HospitalModal>> getAllHospitalsName(){
        List<HospitalModal> list = service.getAllHospitals();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

}
