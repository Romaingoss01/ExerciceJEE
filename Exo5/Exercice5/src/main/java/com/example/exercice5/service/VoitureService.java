package com.example.exercice5.service;


import com.example.exercice5.model.Voiture;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class VoitureService {

    private List<Voiture> voitures;

    public VoitureService() {
        voitures = new ArrayList<>();
        voitures.add(new Voiture(1,"BMW",2000,"Bleu"));
        voitures.add(new Voiture(2,"BMW",2020,"Noir"));
        voitures.add(new Voiture(3,"AUDI",2010,"Rouge"));
        voitures.add(new Voiture(4,"PEUGEOT",2003,"Vert"));
    }

    public Voiture save(int id, String marque, int annee, String couleur){
        Voiture v = new Voiture(id,marque,annee,couleur);
        voitures.add(v);
        return v;
    }

    public List<Voiture> getAll() {
        return voitures;
    }

    public Voiture getById(int id) {
        for (Voiture voiture : voitures) {
            if (voiture.getId() == id) {
                return voiture;
            }
        }
        return null;
    }

    public boolean supprimerVoiture(int id) {
        Voiture voiture = getById(id);
        if (voiture != null) {
            voitures.remove(voiture);
            return true;
        }
        return false;
    }

    public Voiture update(Voiture voiture) {
        Voiture v = getById(voiture.getId());
        v.setMarque(voiture.getMarque());
        v.setCouleur(voiture.getCouleur());
        v.setFabricationAnnee(voiture.getFabricationAnnee());
        return v;
    }
}
