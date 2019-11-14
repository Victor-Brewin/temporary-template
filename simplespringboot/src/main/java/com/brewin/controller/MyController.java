package com.brewin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class MyController {

    @GetMapping("/hello1")
    @ResponseBody
    public String hello() {
      return "Hello World1";
    }
    @GetMapping("/about11")
    public String about() {
        return "about11";
    }
    @RequestMapping("/about12")
    public String about2() {
        return "about12";
    }
}
