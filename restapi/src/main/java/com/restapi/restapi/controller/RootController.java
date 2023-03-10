package com.restapi.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restapi.restapi.httpresponse.HttpResponses;
import com.restapi.restapi.security.EncryptDecryptHelper;
import com.restapi.restapi.services.Service;

@RestController
public class RootController {

    // @Autowired
    // private Service service;

    @Autowired
    private EncryptDecryptHelper decryptHelper;

    @Autowired
    private HttpResponses httpResponses;

    @GetMapping("/home")
    public String test() {
        String testmsg = "This is Test Method";
        return httpResponses.httpResponses(testmsg);

    }

    @GetMapping(value = "/name", produces = "application/json")
    public String getAllHospitalsName() {
        // System.out.println(ResponseEntity.status();
        String list = "";
        try {
            list = decryptHelper.getAllHospitals();
            return httpResponses.httpResponses(list);
        } catch (Exception e) {
            return httpResponses.httpResponses("Something Went Wrong", list, (int) HttpStatus.NOT_FOUND.value()); 
        }
    }

}
