package com.restapi.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    

    @GetMapping("/home")
    public String test(){
        return "Test Method";

    }


}
