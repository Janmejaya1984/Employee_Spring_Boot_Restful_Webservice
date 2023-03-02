package com.example.dbdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

//http://localhost:8083/api/v1/date -POST
@RestController
@RequestMapping("/api/v1/date")
public class DateController {
    @GetMapping
    public String getDate(){
        return LocalDateTime.now().toString();
    }
    @PostMapping
    public String fomatDate(LocalDateTime date){
        return null;
    }
}
