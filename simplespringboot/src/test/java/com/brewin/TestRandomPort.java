package com.brewin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestRandomPort {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testHello() {
      // 测试hello方法
      String result = restTemplate.getForObject("/hello", String.class);
      System.out.println(result);
//      assertEqusals("Hello World", result);
    }
}