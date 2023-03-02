package com.restapi.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restapi.restapi.dao.HospitalRepo;
import com.restapi.restapi.modal.HospitalModal;

@Component
public class Service {
    
    @Autowired
    private HospitalRepo hospitalRepo;

    public List<HospitalModal> getAllHospitals(){
        
        List<HospitalModal> list = this.hospitalRepo.getHospitalModalsList();
        return list;
    }

}
