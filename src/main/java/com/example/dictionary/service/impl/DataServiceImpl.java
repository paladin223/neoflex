package com.example.dictionary.service.impl;

import com.example.dictionary.model.Data;
import com.example.dictionary.repository.DataRepository;
import com.example.dictionary.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DataServiceImpl implements DataService {
    private final DataRepository repository;

    @Override
    public Data postData(Data data){
        return repository.save(data);
    }
}
