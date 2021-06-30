package com.gbm.samples.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns =  "/app")
public class AppServlet extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String htmlOutput = "<html><h2>Hello! Welcome to Open Liberty</h2></html>";
    resp.getWriter().append(htmlOutput);
  }

}
