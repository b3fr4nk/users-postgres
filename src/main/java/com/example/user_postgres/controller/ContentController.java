package com.example.user_postgres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ContentController {
    @GetMapping("/index")
    public String home(){
        return "index";
    }

}