package com.example.tpfinal.repository;

import org.hibernate.Session;
import com.example.tpfinal.model.Patient;

import java.util.List;

public class PatientRepository extends Repository<Patient> {

    public PatientRepository(Session session) {
        super(session);
    }

    @Override
    public List<Patient> findAll() {
        return _session.createQuery("from Patient ").list();
    }

    @Override
    public Patient findById(int id) {
        return _session.get(Patient.class, id);
    }

    @Override
    public Patient findByName(String name) {
        return _session.get(Patient.class, name);
    }
}
