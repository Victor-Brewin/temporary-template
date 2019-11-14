package com.brewin.scope2;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeConfig {
    
    @Autowired
    BeanFactory factory;
    
    @PostConstruct
    public void customScopeConfigurer() {
        CustomScopeConfigurer config = new CustomScopeConfigurer();
        config.addScope("four", new MyScope());
        config.postProcessBeanFactory((ConfigurableListableBeanFactory)factory);
    }

    @Bean
    @Scope(scopeName = "four")
    public ScopeBean beanA() {
        return new ScopeBean();
    }
}
