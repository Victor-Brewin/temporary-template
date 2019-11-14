package com.brewin.mc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brewin.oc.MyBean;

@ConditionalOnMyTerm
@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
