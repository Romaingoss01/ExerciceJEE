package com.example.exercice4.service;

import com.example.exercice4.model.Dog;

import java.util.List;

public interface IServiceDog {
    List<Dog> getAll();
    void addDog(Dog dog);
}

