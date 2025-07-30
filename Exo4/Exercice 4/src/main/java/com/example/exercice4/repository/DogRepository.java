package com.example.exercice4.repository;

import com.example.exercice4.model.Dog;
import org.hibernate.Session;

import java.util.List;

public class DogRepository extends Repository<Dog> {


    public DogRepository(Session session) {
        super(session);
    }

    @Override
    public List<Dog> findAll() {
        return List.of();
    }
}
