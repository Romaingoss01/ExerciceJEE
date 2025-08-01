package com.example.tpfinal.controller;

import com.example.tpfinal.model.Patient;
import com.example.tpfinal.service.PatientService;
import com.example.tpfinal.utils.HibernateSession;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Hibernate;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "PatientController", value = "/PatientController/*")
public class PatientController extends HttpServlet {

    private PatientService patientService;
    @Override
    public void init() throws ServletException {
        patientService = new PatientService(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getPathInfo().substring(1);
        System.out.println("action: " + action);
        switch (action) {
            case "list":
                showAll(req,resp);
                break;
            case "addform":
                showForm(req,resp);
                break;
            case "add":
                add(req,resp);
                break;
            case "detail":
                showDetails(req,resp);
                break;

        }
    }

    protected void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        req.setAttribute("patient", patientService.getAll());
        req.getRequestDispatcher("/WEB-INF/patient/listPatient.jsp").forward(req,resp);
    }

    protected void showForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Patient patientAjout = new Patient();
        req.setAttribute("patient", patientAjout);
        req.setAttribute("mode","add");
        req.getRequestDispatcher("WEB-INF/patient/addPatient.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        int telephone = Integer.parseInt(req.getParameter("telephone"));
        LocalDate dob = LocalDate.parse(req.getParameter("dateDeNaissance"));
        String photo = req.getParameter("photo");
        patientService.addPatient(new Patient(id, nom, prenom, telephone, dob, photo));
        resp.sendRedirect("listPatient.jsp");
    }

    protected void showDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id = Integer.parseInt(req.getParameter("id"));
        Patient patientTrouve = patientService.getPatient(id);
        req.setAttribute("patient", patientTrouve);
        req.setAttribute("mode","view");
        req.getRequestDispatcher("/WEB-INF/patient/detailPatients.jsp").forward(req,resp);
    }
}

