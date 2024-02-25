package com.pankaj846.restapis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {


    //@RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/health")
    public String hello(){
        return "health ok!!";
    }
}
