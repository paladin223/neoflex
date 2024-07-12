package com.example.dictionary.model;

import jakarta.persistence.*;

import java.util.Set;

@lombok.Data
@Entity
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dictionary_seq_gen")
    @SequenceGenerator(name = "dictionary_seq_gen", sequenceName = "dictionary_seq", allocationSize = 1)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(nullable = false, length = 50)
    private String description;

    @OneToMany(mappedBy = "dictionary", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Data> data;
}
