package com.example.exo1;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletHTMLTXT", value = "/ServletHTMLTXT")
public class ServletTXTHTML extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ServletTXTHTML</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Je sort du texte HTML depuis un servlet !</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
