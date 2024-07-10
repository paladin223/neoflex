package com.example.dictionary.service;

import com.example.dictionary.model.Dictionary;

import java.util.List;

public interface DictionaryService {
    List<Dictionary> getDictonaries();
    Dictionary postDictionary(Dictionary dictionary);
    void deleteDictionary(String code);
}
