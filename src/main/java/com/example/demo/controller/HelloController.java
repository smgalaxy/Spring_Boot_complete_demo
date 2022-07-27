package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //@RequestMapping(value = "/hi",method = RequestMethod.GET)
    @GetMapping("/hi")
    public String helloController()
    {
        System.out.println("hi");
        return "Hi, Welcome to our page!";
    }
}
