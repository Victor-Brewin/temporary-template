package com.brewin.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class MyConfig {

    @Bean
    public MyBean getMyBean() {
        return new MyBean();
    }
    
    @Bean("bean2")
    public MyBean myBean2() {
        return new MyBean();
    }
}
