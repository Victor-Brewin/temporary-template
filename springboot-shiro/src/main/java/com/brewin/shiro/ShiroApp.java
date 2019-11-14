package com.brewin.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.brewin.shiro.dao")
public class ShiroApp {
	 public static void main(String[] args) {
	        SpringApplication.run(ShiroApp.class, args);
	    }
}
