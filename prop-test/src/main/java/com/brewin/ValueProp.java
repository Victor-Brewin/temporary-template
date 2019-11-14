package com.brewin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ValueProp {

    @Value("${jdbc.url}")
    private String jdbcUrl;

    public String getJdbcUrl() {
      return jdbcUrl;
    }
}