package com.geraud.ocr_bibliotheque.controllers;

import com.geraud.ocr_bibliotheque.domain.Book;
import com.geraud.ocr_bibliotheque.exceptions.ResultNotFoundException;
import com.geraud.ocr_bibliotheque.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void showBookByIsbn() throws Exception {

        Book book1 = new Book();
        book1.setIsbn("3456");
        book1.setTitle("Book 1");

        doReturn(book1).when(bookService).findByIsbn("3456");

        this.mockMvc.perform(get("/book/{isbn}/show", "3456"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("Book 1")));
    }

    @Test
    void notFoundBookByIsbn() throws Exception {

        doThrow(ResultNotFoundException.class).when(bookService).findByIsbn(anyString());

        this.mockMvc.perform(get("/book/{isnb}/show", "0000"))
                .andExpect(status().isNotFound());
    }
}