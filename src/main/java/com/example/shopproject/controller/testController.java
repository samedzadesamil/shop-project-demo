package com.example.shopproject.controller;


import com.example.shopproject.model.Users;
import com.example.shopproject.model.dto.LoginUserDto;
import com.example.shopproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/sik")
public class testController {
    @Autowired
    UserService userService;

    @GetMapping("/sikerem")
    public String getAzerbaijaniRomanticBooks() {
        return "sikdir";

    }
    @PostMapping("/registration")
    public String registration(@RequestBody Users users){
        System.out.println("gonderildi");
        return userService.registrationUser(users);

    }
    @PostMapping("/login")
    public String login(@RequestBody LoginUserDto dto){
        return userService.loginUser(dto.getUsername(), dto.getPassword());
    }

}

