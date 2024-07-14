package com.example.dictionary.mappings;

import com.example.dictionary.DTO.DictionaryView;
import com.example.dictionary.model.Dictionary;
import org.springframework.stereotype.Component;

@Component
public class DictionaryProfile {
    public DictionaryView dictionaryToDictionaryView(Dictionary dictionary){
        var view = new DictionaryView();
        view.setCode(dictionary.getCode());
        view.setDescription(dictionary.getDescription());
        return view;
    }

    public Dictionary dictionaryViewToDictionary(DictionaryView dictionary){
        var entity = new Dictionary();
        entity.setCode(dictionary.getCode());
        entity.setDescription(dictionary.getDescription());
        return entity;
    }
}
