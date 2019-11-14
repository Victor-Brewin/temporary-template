package com.brewin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class ThyApp {

    public static void main(String[] args) {
        SpringApplication.run(ThyApp.class, args);
    }
    
    @RequestMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", queryUsers());
        return "user";
    }
    @GetMapping("/about")
    public String about2() {
        
        return "about";
    }

    private List<User> queryUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "userA"));
        users.add(new User(2, "userB"));
        return users;
    }
    
    @RequestMapping("/test")
    public String test() {
        return "test";
    }
}