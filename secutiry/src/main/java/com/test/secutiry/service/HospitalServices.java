package com.test.secutiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.secutiry.data.HospitalRepo;
import com.test.secutiry.model.HospitalModal;
import com.test.secutiry.security.Encryption;

@Service
public class HospitalServices {
    
    @Autowired
    private HospitalRepo repo;

    @Autowired
    private Encryption encryption;

    public String getAllencryptedHospitalNames() throws Exception{

        List<HospitalModal> data = repo.getAllHospitalNames();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(data);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("===========================================================================================================================");
        System.out.println("===========================================================================================================================");
        System.out.println(jsonString);
        System.out.println("===========================================================================================================================");
        System.out.println("===========================================================================================================================");
        System.out.println(encryption.encrypt(jsonString));
        String EncryptedData = encryption.encrypt(jsonString);
        System.out.println("===========================================================================================================================");
        System.out.println("===========================================================================================================================");
        System.out.println(encryption.decrypt(EncryptedData));
        String DecryptedData = encryption.decrypt(EncryptedData);
        
        return EncryptedData;
    }

}
