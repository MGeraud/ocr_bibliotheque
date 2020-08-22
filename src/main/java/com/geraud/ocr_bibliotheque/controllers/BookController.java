package com.geraud.ocr_bibliotheque.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller pour récupérer et renvoyer le(s) livre(s) en fonction de différents critères
 * Todo : ajouter les méthodes pour le client des employés afin d'ajouter de nouveaux livres
 */
@RestController
public class BookController {

    @RequestMapping(value = "/book/{id}/show")
    public String showBookById(@PathVariable String id){

        return "Affichera livre avec id : " + id;
    }

}
