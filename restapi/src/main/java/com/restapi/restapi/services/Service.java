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
    private HospitalRepo hospitalRepo;

    @Autowired
    private encryptDecrypt eDecrypt;

    public String getAllHospitals() throws Exception{
        
        final String secretKey = "admin";

        List<HospitalModal> list = this.hospitalRepo.getHospitalModalsList();
        System.out.println("=====================ORIGINAL DATA=======================");
        System.out.println(list);
        System.out.println("=========================================================");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(eDecrypt.encrypt(list.toString(), secretKey));
        // return list.toString();
        return eDecrypt.encrypt(list.toString(), secretKey);
        // throw new Exception("jhasdfui");
    }

}
