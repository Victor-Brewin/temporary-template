package com.brewin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyService {

    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate() {
      return builder.rootUri("http://localhost:8080").build();
    }

//    
//     使用RestTemplateBuilder来创建template
//    
    public Person useBuilder() {
      Person p = restTemplate().getForObject("/person/angus", Person.class);
      return p;
    }
}
