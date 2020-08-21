package com.geraud.ocr_bibliotheque.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"books"})
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_author;

    private String first_name;
    private String last_name;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}
