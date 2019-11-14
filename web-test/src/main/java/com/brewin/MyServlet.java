package com.brewin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/servlet")
public class MyServlet extends HttpServlet {
    public MyServlet() {
        System.out.println("my servlet class");
    }

    protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
          throws ServletException, IOException {
        System.out.println("servlet service method");
    }
}