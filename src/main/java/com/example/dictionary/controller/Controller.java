package com.example.dictionary.controller;

import com.example.dictionary.DTO.DataView;
import com.example.dictionary.mappings.DataProfile;
import com.example.dictionary.mappings.DictionaryProfile;
import com.example.dictionary.service.DataService;
import com.example.dictionary.service.DictionaryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.dictionary.model.Data;
import com.example.dictionary.model.Dictionary;
import com.example.dictionary.DTO.DictionaryView;


import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class Controller {
    private final DictionaryService dictionaryService;
    private final DictionaryProfile dictionaryProfile;
    private final DataService dataService;
    private final DataProfile dataProfile;

    @GetMapping("/dictionaries")
    public List<Dictionary> getDictonaries() {
        return dictionaryService.getDictonaries();
    }

    @PostMapping("/dictionaries")
    public Dictionary postDictionary(@RequestBody DictionaryView dictionary) {
        var entity = dictionaryProfile.dictionaryViewToDictionary(dictionary);
        return dictionaryService.postDictionary(entity);
    }

    @DeleteMapping("/dictionaries")
    public void deleteDictionary(@RequestParam String code) {
        dictionaryService.deleteDictionary(code);
    }

//    @GetMapping("/dictionaries/records")
//    public List<Data> getDictonaryData(String code) {
//        return dataService.getDictonaryData(code);
//    }

    @PostMapping("/dictionaries/records")
    public Data postData(@RequestBody DataView data) {
        var entity = dataProfile.dataViewToData(data);
        return dataService.postData(entity);
    }
}
