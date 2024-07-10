package com.example.dictionary.service.impl;

import com.example.dictionary.model.Dictionary;
import com.example.dictionary.repository.DictionaryRepository;
import com.example.dictionary.service.DictionaryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repository.save(dictionary);
    }

    @Override
    public void deleteDictionary(String code) {
        repository.deleteByCode(code);
    }
}
