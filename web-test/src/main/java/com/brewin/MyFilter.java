package com.brewin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(value = "/filter/*")
public class MyFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {
      System.out.println("my filter init");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain) throws IOException, ServletException {
      System.out.println("doFilter method");
      chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
