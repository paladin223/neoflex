package com.example.dictionary.model;

import jakarta.persistence.*;

import java.util.UUID;
import lombok.*;

@lombok.Data
@Entity
public class Data {
    @Id
    @GeneratedValue
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