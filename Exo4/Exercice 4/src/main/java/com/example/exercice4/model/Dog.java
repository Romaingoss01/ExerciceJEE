package com.example.exercice4.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDate;

@Entity
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nom;
    private String race;
    @Temporal(TemporalType.DATE)
    private LocalDate dateDeNaissance;

    public Dog(String nom, String race, LocalDate dateDeNaissance) {
        this.nom = nom;
        this.race = race;
        this.dateDeNaissance = dateDeNaissance;
    }

    public Dog() {

    }

    public String getNom() {return nom;}
    public void setNom(String nom) {this.nom = nom;}
    public String getRace() {return race;}
    public void setRace(String race) {this.race = race;}
    public LocalDate getDateDeNaissance() {return dateDeNaissance;}
    public void setDateDeNaissance(LocalDate dateDeNaissance) {this.dateDeNaissance = dateDeNaissance;}
    public int getId() {return id;}


}