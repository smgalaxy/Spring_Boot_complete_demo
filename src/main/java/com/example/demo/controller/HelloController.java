package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@RequestMapping(value = "/hi",method = RequestMethod.GET)
    @Value("${welcome.message}")
    private String welcomeMessage;
    @GetMapping("/hi")
    public String helloController()
    {
        //System.out.println("hi");
        return welcomeMessage;
    }
}
