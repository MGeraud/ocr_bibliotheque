package com.geraud.ocr_bibliotheque.controllers;

import com.geraud.ocr_bibliotheque.domain.Book;
import com.geraud.ocr_bibliotheque.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller pour récupérer et renvoyer le(s) livre(s) en fonction de différents critères
 * Todo : ajouter les méthodes pour le client des employés afin d'ajouter de nouveaux livres
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * requete recherche livre par son isbn
     *
     * @param isbn identifiant isbn du livre à rechercher
     * @return description du livre dont l'isbn correspont à celui recherché
     */
    @RequestMapping(value = "/book/{isbn}/show")
    public Book showBookByIsbn(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }

    @RequestMapping(value = "/book/show")
    public Page<Book> showAllWithPagination() {

        return bookService.findAllWithPagination(0, 15);
    }

    /**
     * requete recherche livre par auteur(s)
     *
     * @param page   numéro de page recherchée (par défaut 1ère page de recherche)
     * @param size   nombre de livres maximum par page (par défaut 10)
     * @param author critère de recherche pour les livres : auteur(s)
     * @return page contenant une liste de livres correspondant aux auteurs recherchés
     */
    @RequestMapping(value = "/book/author/show")
    public Page<Book> showByAuthor(@RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "size", defaultValue = "10") int size,
                                   @RequestParam("author") String author) {

        Pageable pageable = PageRequest.of(page, size);
        return bookService.findByAuthor(author, pageable);
    }

    /**
     * requete recherche livre par titre
     *
     * @param page  numéro de page recherchée (par défaut 1ère page de recherche)
     * @param size  nombre de livres maximum par page (par défaut 10)
     * @param title critère de recherche pour les livres : titre
     * @return page contenant une liste de livres correspondant au titre recherché
     */
    @RequestMapping(value = "/book/title/show")
    public Page<Book> showByTitle(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "10") int size,
                                  @RequestParam("title") String title) {

        Pageable pageable = PageRequest.of(page, size);
        return bookService.findByTitle(title, pageable);
    }

    /**
     * requete recherche livre par sujet(s)
     *
     * @param page  numéro de page recherchée (par défaut 1ère page de recherche)
     * @param size  nombre de livres maximum par page (par défaut 10)
     * @param topic critère de recherche pour les livres : sujet(s) du livre
     * @return page contenant une liste de livres correspondant au(x) sujet(s) recherché(s)
     */
    @RequestMapping(value = "/book/topic/show")
    public Page<Book> showByTopic(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "10") int size,
                                  @RequestParam("topic") String topic) {

        Pageable pageable = PageRequest.of(page, size);
        return bookService.findByTopic(topic, pageable);
    }
}
