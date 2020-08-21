package com.geraud.ocr_bibliotheque.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_library;

    private String library_name;
    private String opening_hours;
    private String address;

    @OneToMany(mappedBy = "pk.library")
    private Set<Stock> stocks = new HashSet<>();
}
