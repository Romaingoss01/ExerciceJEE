package com.example.exercice5.model;

import java.time.LocalDate;

public class Voiture {

    private int id;
    private String marque;
    private int fabricationAnnee;
    private String couleur;


    public Voiture(int id, String marque, int fabricationAnnee,  String couleur) {
        this.id = id;
        this.marque = marque;
        this.fabricationAnnee = fabricationAnnee;
        this.couleur = couleur;
    }

    public Voiture() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getFabricationAnnee() {
        return fabricationAnnee;
    }

    public void setFabricationAnnee(int fabricationAnnee) {
        this.fabricationAnnee = fabricationAnnee;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getAnnee() {
        return fabricationAnnee;
    }
}
