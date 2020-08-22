package com.geraud.ocr_bibliotheque.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Book {

    @Id
    private Long isbn;

    private String title;
    private String description;
    private LocalDate year;

    @Enumerated(value = EnumType.STRING)
    private Theme theme;

    @ManyToMany
    @JoinTable(name = "book_author" , joinColumns = @JoinColumn(name = "isbn") , inverseJoinColumns = @JoinColumn(name = "id_author"))
    private Set<Author> authors = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "book_topics" , joinColumns = @JoinColumn(name = "isbn") , inverseJoinColumns = @JoinColumn(name = "id_topics"))
    private Set<Topic> topics = new HashSet<>();

    @ManyToOne
    private Publisher publisher;

    @OneToMany(mappedBy = "pk.book")
    private Set<Stock> stocks = new HashSet<>();
}
