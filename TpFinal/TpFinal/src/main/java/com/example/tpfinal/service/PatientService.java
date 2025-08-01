package com.example.tpfinal.service;

import com.example.tpfinal.model.Patient;
import com.example.tpfinal.repository.PatientRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class PatientService {

    private PatientRepository dogRepository;
    private SessionFactory _sessionFactory;
    private Session session;

    public PatientService(SessionFactory _sessionFactory) {
        this._sessionFactory = _sessionFactory;
    }


    public List<Patient> getAll() {
        List<Patient> patients = new ArrayList<>();
        session = _sessionFactory.openSession();
        dogRepository = new PatientRepository(session);
        try {
            patients = dogRepository.findAll();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return patients;
    }

    public void addPatient(Patient patient) {
        session = _sessionFactory.openSession();
        session.beginTransaction();
        dogRepository =  new PatientRepository(session);
        try {
            dogRepository.create(patient);
            session.getTransaction().commit();
        }catch(Exception e){
            try {
                session.getTransaction().rollback();
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }finally {
            session.close();
        }
    }

    public Patient getPatient(int id) {
        Patient patient = null;
        session = _sessionFactory.openSession();
        dogRepository = new PatientRepository(session);
        try {
            patient = dogRepository.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return patient;
    }


}
