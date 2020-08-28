package com.geraud.ocr_bibliotheque.services;

import com.geraud.ocr_bibliotheque.dao.AuthorDao;
import com.geraud.ocr_bibliotheque.dao.BookDao;
import com.geraud.ocr_bibliotheque.domain.Author;
import com.geraud.ocr_bibliotheque.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorDao authorDao;

    /**
     *
     * @param isbn du livre recherché
     * @return livre avec l'isbn recherché
     */
    @Override
    public Book findByIsbn(String isbn) {
        return bookDao.findBookByIsbn(isbn);
    }

    @Override
    public Page<Book> findAllWithPagination(int page, int size) {
        return bookDao.findAll(PageRequest.of(page, size));
    }


    /**
     *Méthode de recherche de livres par auteur avec pagination
     * @param name : nom et/ou prenom de l'auteur (en entier ou partiel)
     * @param pageable objet de type Pageable contenant le numéro de page et le nombre d'objet par page
     * @return Page contenant une liste de livres limitée à la taille choisie
     */
    @Override
    public Page<Book> findByAuthor(String name, Pageable pageable) {

        /*Décomposition de l'entrée name en mots distincts les uns des autres (présupposés nom et prénom) */
        List<String> wordByWord = Arrays.asList(name.split("[ ]"));

        /*Création d'une liste d'auteurs dont l'un des mots correspond au nom ou prénom d'un auteur de la base de données  */
        List<Author> authors = new ArrayList<>();

        for (String word : wordByWord){
             List<Author> foundAuthors = authorDao.findAuthorsByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(word , word);
             authors.addAll(foundAuthors);
        }


        /*recherche des livres correspondants à l'un des auteurs de la liste trouvée */
        return bookDao.findDistinctByAuthorsIn(authors  , pageable);
    }
}
