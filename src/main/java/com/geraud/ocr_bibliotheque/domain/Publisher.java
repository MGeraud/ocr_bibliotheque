package com.geraud.ocr_bibliotheque.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_publisher;

    private String name;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books;
}
