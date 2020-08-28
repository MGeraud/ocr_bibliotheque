package com.geraud.ocr_bibliotheque.dao;

import com.geraud.ocr_bibliotheque.domain.Author;
import com.geraud.ocr_bibliotheque.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookDao extends JpaRepository <Book , Long > {

    Book findBookByIsbn(String isbn);
    Page<Book> findDistinctByAuthorsIn(List<Author> authors , Pageable pageable);

}
