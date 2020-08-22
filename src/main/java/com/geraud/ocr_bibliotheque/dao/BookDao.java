package com.geraud.ocr_bibliotheque.dao;

import com.geraud.ocr_bibliotheque.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository <Book , String > {

    Book findBookByIsbn(String isbn);
}
