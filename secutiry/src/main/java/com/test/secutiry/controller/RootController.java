package com.test.secutiry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.secutiry.service.HospitalServices;

@RestController
public class RootController {

    @Autowired
    private HospitalServices hospitalServices;
    
    @GetMapping("/")
    public String testing() {

        System.out.println("This is Testing  Method ");
        return "Working Successfully....";
        
    }

    @GetMapping(value = "/encrypt", produces = "application/json")
    public String EncryptedData() throws Exception{
        System.out.println();
        System.out.println("=====================================================================================================");
        System.out.println("Encryption Method");
        return hospitalServices.getAllencryptedHospitalNames();
    }

}
