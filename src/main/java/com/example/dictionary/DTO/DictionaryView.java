package com.example.dictionary.DTO;

import jakarta.persistence.Entity;

import lombok.Data;

@Data
public class DictionaryView {
    private String code;
    private String description;
}
