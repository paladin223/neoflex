package com.example.dictionary.model;

import jakarta.persistence.*;

import java.util.Set;
import java.util.UUID;
import lombok.*;

@lombok.Data
@Entity
public class Dictionary {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false, length = 50)
    private String code;

    @Column(nullable = false, length = 50)
    private String description;

    @OneToMany(mappedBy = "dictionary", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Data> data;
}
