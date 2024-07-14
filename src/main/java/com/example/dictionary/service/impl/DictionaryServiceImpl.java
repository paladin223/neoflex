package com.example.dictionary.service.impl;

import com.example.dictionary.model.Dictionary;
import com.example.dictionary.repository.DictionaryRepository;
import com.example.dictionary.service.DictionaryService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DictionaryServiceImpl implements DictionaryService {
    private final DictionaryRepository repository;

    @Override
    public List<Dictionary> getDictonaries() {
        return repository.findAll();
    }

    @Override
    public Dictionary postDictionary(Dictionary dictionary) {
        Optional<Dictionary> existingDictionary = repository.findByCode(dictionary.getCode());
        if (existingDictionary.isPresent()) {
            throw new IllegalArgumentException("Dictionary with code " + dictionary.getCode() + " already exists.");
        }
        return repository.save(dictionary);
    }

    @Override
    @Transactional
    public void deleteDictionary(String code) {
        repository.deleteByCode(code);
    }
}
