package com.example.dictionary.service.impl;

import com.example.dictionary.DTO.DataView;
import com.example.dictionary.mappings.DataProfile;
import com.example.dictionary.model.Data;
import com.example.dictionary.model.Dictionary;
import com.example.dictionary.repository.DataRepository;
import com.example.dictionary.repository.DictionaryRepository;
import com.example.dictionary.service.DataService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DataServiceImpl implements DataService {
    private final DataRepository dataRepository;
    private final DictionaryRepository dictionaryRepository;
    private final DataProfile dataProfile;

    @Override
    public Data postData(DataView data){
        var entity = dataProfile.dataViewToData(data);
        var dict = dictionaryRepository.findByCode(data.getDictionaryCode()).orElseThrow(
                () -> new EntityNotFoundException("Dictionary not found with code: " + data.getDictionaryCode()));
        entity.setDictionary(dict);
        return dataRepository.save(entity);
    }

    @Override
    public List<Data> getDictonaryData(String code){
        Dictionary dictionary = dictionaryRepository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Dictionary not found with code: " + code));
        return dataRepository.findByDictionary(dictionary);
    }
}
