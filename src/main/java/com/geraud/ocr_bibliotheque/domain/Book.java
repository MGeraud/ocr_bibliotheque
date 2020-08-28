package com.geraud.ocr_bibliotheque.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_book;

    @Column(unique = true)
    private String isbn;

    private String title;

    @Lob
    private String description;
    private int year;
    private String image;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @ManyToMany
    @JoinTable(name = "book_author" , joinColumns = @JoinColumn(name = "id_book") , inverseJoinColumns = @JoinColumn(name = "id_author"))
    private Set<Author> authors = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "book_topics" , joinColumns = @JoinColumn(name = "id_book") , inverseJoinColumns = @JoinColumn(name = "id_topics"))
    private Set<Topic> topics = new HashSet<>();

    @ManyToOne
    private Publisher publisher;

    @OneToMany(mappedBy = "pk.book")
    private Set<Stock> stocks = new HashSet<>();
}
