package com.example.dictionary.model;

import jakarta.persistence.*;

@lombok.Data
@Entity
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_seq_gen")
    @SequenceGenerator(name = "data_seq_gen", sequenceName = "data_seq", allocationSize = 1)
    @Column(nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dictionary_id", nullable = false)
    private Dictionary dictionary;

    @Column(nullable = false, length = 50)
    private String code;

    @Column(nullable = false, length = 50)
    private String value;
}