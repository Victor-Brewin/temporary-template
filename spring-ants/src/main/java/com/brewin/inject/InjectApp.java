package com.brewin.inject;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class InjectApp {

    public static void main(String[] args) {
      SpringApplication.run(InjectApp.class, args);
    }

    // 使用@Resource注入
    @Resource(name = "myBean1")
    InjectBean myBean1;

    // 使用@Autowired注入
    @Autowired
    InjectBean myBean2;

    @GetMapping("/inject")
    public String inject() {
      System.out.println(myBean1.getId());
      System.out.println(myBean2.getId());
      return "";
    }
}
