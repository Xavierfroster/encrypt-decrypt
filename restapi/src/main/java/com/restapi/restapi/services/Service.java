package com.restapi.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.restapi.dao.HospitalRepo;
import com.restapi.restapi.modal.HospitalModal;
import com.restapi.restapi.security.encryptDecrypt;

@Component
public class Service {

    @Autowired
    private encryptDecrypt eDecrypt;

    public String getAllHospitals(){
        return null;
  }

}
