package com.example.shopproject.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/sik")
public class testController {

    @GetMapping("/sikerem")
    public String getAzerbaijaniRomanticBooks() {
        return "sikdir";

    }
    
}
