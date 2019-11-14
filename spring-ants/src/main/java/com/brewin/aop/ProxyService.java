package com.brewin.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProxyService {

    @Before("execution(* com.brewin.aop.*ServiceImpl.*(..))")
    public void before() {
      System.out.println("业务方法调用前执行");
    }

    @After("execution(* com.brewin.aop.*ServiceImpl.*(..))")
    public void after() {
      System.out.println("业务方法调用后执行");
    }
}
