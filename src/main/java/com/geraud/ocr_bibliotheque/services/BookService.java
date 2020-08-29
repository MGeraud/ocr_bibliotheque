package com.geraud.ocr_bibliotheque.services;

import com.geraud.ocr_bibliotheque.domain.Author;
import com.geraud.ocr_bibliotheque.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Book findByIsbn(String isbn);
    Page<Book> findByTitle(String title , Pageable pageable);
    Page<Book> findAllWithPagination(int page , int size);
    Page<Book> findByAuthor(String name, Pageable pageable);
    Page<Book> findByTopic(String topic, Pageable pageable);
}
