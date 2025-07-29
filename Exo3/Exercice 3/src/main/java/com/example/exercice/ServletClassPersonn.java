package com.example.exercice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletClassPersonn", value = "/ServletClassPersonn")
public class ServletClassPersonn extends HttpServlet {
    private String nom;
    private String prenom;
    private int age;

    public void init() throws ServletException {
        nom = "gosselin";
        prenom = " romain";
        age = 22;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("nom", nom);
        req.setAttribute("prenom", prenom);
        req.setAttribute("age", age);
        req.getRequestDispatcher("personne.jsp").forward(req, resp);
    }
}

