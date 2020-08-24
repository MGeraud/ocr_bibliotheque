package com.geraud.ocr_bibliotheque.controllers;

import com.geraud.ocr_bibliotheque.dao.BookDao;
import com.geraud.ocr_bibliotheque.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller pour récupérer et renvoyer le(s) livre(s) en fonction de différents critères
 * Todo : ajouter les méthodes pour le client des employés afin d'ajouter de nouveaux livres
 */
@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;

    @RequestMapping(value = "/book/{isbn}/show")
    public Book showBookById(@PathVariable String isbn){
        Book trouve = bookDao.findBookByIsbn(isbn);

        System.out.println(trouve.getPublisher().getName());

        return bookDao.findBookByIsbn(isbn);
    }

    @RequestMapping(value = "/book/show")
    public Page<Book> showAllWithPagination (){

        return bookDao.findAll(PageRequest.of(0,3));
    }

}
