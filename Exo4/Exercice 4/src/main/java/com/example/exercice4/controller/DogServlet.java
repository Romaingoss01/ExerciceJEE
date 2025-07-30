package com.example.exercice4.controller;


import com.example.exercice4.model.Dog;
import com.example.exercice4.service.IServiceDog;
import com.example.exercice4.service.ServiceDogBDD;
import com.example.exercice4.util.HibernateSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DogServlet", value = "/DogServlet")
public class DogServlet extends HttpServlet {

    private IServiceDog serviceDog;

    public void init() throws ServletException {
        serviceDog = new ServiceDogBDD(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // afficher la page formulaire
        req.setAttribute("dogList", serviceDog.getAll());
        req.getRequestDispatcher("/WEB-INF/dog/addDog.jsp").forward(req, resp);
    }

}
