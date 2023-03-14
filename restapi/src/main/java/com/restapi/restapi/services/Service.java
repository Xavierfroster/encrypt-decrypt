package com.restapi.restapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.restapi.security.encryptDecrypt;

@Component
public class Service {

    @Autowired
    private encryptDecrypt eDecrypt;

    public String getAllHospitals(){
        return eDecrypt.encrypt("HelloWorld", "Admin123456");
  }

}
