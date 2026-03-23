package com.kazuki.reservation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController; 

@RestController
public class HelloControkller {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
