package com.restapi.restapi.security;

import java.util.List;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restapi.restapi.dao.HospitalRepo;
import com.restapi.restapi.modal.HospitalModal;

@Component
public class EncryptDecryptHelper {
    
    @Autowired
    private HospitalRepo hospitalRepo;

    public String getAllHospitals() throws Exception{
        List<HospitalModal> list = hospitalRepo.getHospitalModalsList();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(list);
        System.out.println("=================================================================================================================");
        System.out.println("=================================================================================================================");
        System.out.println(jsonString);
        System.out.println("=================================================================================================================");
        System.out.println("=================================================================================================================");
        
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setPassword("mySecretPassword");
        String encryptedJsonString = encryptor.encrypt(jsonString);

        System.out.println("=================================================================================================================");
        System.out.println("=================================================================================================================");
        System.out.println(encryptedJsonString);
        System.out.println("=================================================================================================================");
        System.out.println("=================================================================================================================");


        String decryptedJsonString = encryptor.decrypt(encryptedJsonString);


        System.out.println("=================================================================================================================");
        System.out.println("=================================================================================================================");
        System.out.println(decryptedJsonString);
        System.out.println("=================================================================================================================");
        System.out.println("=================================================================================================================");


        return encryptedJsonString;
    }
}
