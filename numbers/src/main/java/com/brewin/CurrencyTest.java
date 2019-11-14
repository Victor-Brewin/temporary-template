package com.brewin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class CurrencyTest {

    public static void main(String[] args) {
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(new ClassLoaderTemplateResolver());
        Context ctx = new Context(); 
        String result = templateEngine.process("currency.html", ctx);
        System.out.println(result);
    }

}
