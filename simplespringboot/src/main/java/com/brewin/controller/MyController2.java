package com.brewin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class MyController2 {

    
    @GetMapping("/about22")
    public String about2() {
        return "about";
    }
   
}
