package com.brewin.mc;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context,
          AnnotatedTypeMetadata metadata) {
      Environment env = context.getEnvironment();
      String user = env.getProperty("jdbc.user");
      System.out.println("在条件类中获取属性值：" + user);
      // 这个属性值为brewin的时候，条件符合
      if("brewin".equals(user)) {
          return true;
      }
      return false;
    }
}
