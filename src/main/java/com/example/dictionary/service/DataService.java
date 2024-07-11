package com.example.dictionary.service;

import com.example.dictionary.DTO.DataView;
import com.example.dictionary.model.Data;

import java.util.List;

public interface DataService {
    Data postData(DataView data);
    List<Data> getDictonaryData(String code);
}
