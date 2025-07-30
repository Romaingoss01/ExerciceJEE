package com.example.exercice4.service;

import com.example.exercice4.model.Dog;

import java.util.ArrayList;
import java.util.List;

public class ServiceDogList implements IServiceDog {


    private List<Dog> dogList;

    public ServiceDogList() {
        dogList = new ArrayList<Dog>();
    }

    @Override
    public List<Dog> getAll() {
        return dogList;
    }

    @Override
    public void addDog(Dog dog) {
        dogList.add(dog);
    }

}
