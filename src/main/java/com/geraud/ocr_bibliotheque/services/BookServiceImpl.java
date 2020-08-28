package com.geraud.ocr_bibliotheque.services;

import com.geraud.ocr_bibliotheque.dao.BookDao;
import com.geraud.ocr_bibliotheque.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public Book findByIsbn(String isbn) {
        return bookDao.findBookByIsbn(isbn);
    }

    @Override
    public Page<Book> findAllWithPagination(int page, int size) {
        return bookDao.findAll(PageRequest.of(page, size));
    }
}
