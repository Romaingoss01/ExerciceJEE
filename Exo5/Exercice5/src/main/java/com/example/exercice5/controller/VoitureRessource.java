package com.example.exercice5.controller;

import com.example.exercice5.model.Voiture;
import com.example.exercice5.service.VoitureService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/voitures")
public class VoitureRessource {

    @Inject
    VoitureService voitureService;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Voiture> allVoitures() {
        return voitureService.getAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response laVoiture(@PathParam("id") int id) {
        Voiture voiture = voitureService.getById(id);
        if (voiture != null) {
            return Response.ok(voiture).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Voiture ajoutVoiture(Voiture voiture) {
        return voitureService.save(voiture.getId(), voiture.getMarque(), voiture.getAnnee(), voiture.getCouleur());
    }

    @DELETE
    @Path("/{id}")
    public Response supprimerVoiture(@PathParam("id") int id) {
        boolean deleted = voitureService.supprimerVoiture(id);
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

//    @PATCH
//    @Path("/{id}")
//    public Response modifierVoiture(@PathParam("id") int id) {
//        Voiture voiture = voitureService.getById(id);
//        if (voiture != null) {


    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Voiture updateProduct(@PathParam("id") int id) {
        return voitureService.save(id,"tesla", 2025, "violet");
    }
}
