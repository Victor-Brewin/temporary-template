package com.brewin;

import org.springframework.context.annotation.Bean;

import feign.Feign;
import feign.gson.GsonDecoder;

public class FeignMain {
    public static void main(String[] args) {
        // 调用Hello接口
        PersonClient pc = Feign.builder()
              .decoder(new GsonDecoder())
              .target(PersonClient.class, "http://localhost:8080/");
        Person p = pc.getPerson("angus");
        System.out.println(p.getName() + "---" + p.getAge());
    }
    @Bean
    public PersonClient personClient() {
        return Feign.builder()
              .decoder(new GsonDecoder())
              .target(PersonClient.class, "http://localhost:8080/");
    }

 }
