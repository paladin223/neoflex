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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class Controller {
    private final DictionaryService dictionaryService;
    private final DictionaryProfile dictionaryProfile;
    private final DataService dataService;
    private final DataProfile dataProfile;

    @GetMapping("/dictionaries")
    public List<DictionaryView> getDictonaries() {
        List<Dictionary> dictionaryList =  dictionaryService.getDictonaries();

        return dictionaryList.stream()
                .map(dictionaryProfile::dictionaryToDictionaryView)
                .collect(Collectors.toList());
    }

    @PostMapping("/dictionary")
    public Dictionary postDictionary(@RequestBody DictionaryView dictionary) {
        var entity = dictionaryProfile.dictionaryViewToDictionary(dictionary);
        return dictionaryService.postDictionary(entity);
    }

    @DeleteMapping("/dictionary")
    public void deleteDictionary(@RequestParam String code) {
        dictionaryService.deleteDictionary(code);
    }

    @GetMapping("/dictionary/records")
    public List<DataView> getDictonaryData(String code) {
        List<Data> dataList = dataService.getDictonaryData(code);

        return dataList.stream()
                .map(dataProfile::dataToDataView)
                .collect(Collectors.toList());
    }

    @PostMapping("/dictionary/record")
    public DataView postData(@RequestBody DataView data) {
        return dataProfile.dataToDataView(
                dataService.postData(data)
        );
    }
}
