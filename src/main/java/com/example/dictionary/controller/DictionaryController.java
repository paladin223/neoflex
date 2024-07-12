package com.example.dictionary.controller;

import com.example.dictionary.DTO.DictionaryView;
import com.example.dictionary.mappings.DictionaryProfile;
import com.example.dictionary.model.Dictionary;
import com.example.dictionary.service.DictionaryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class DictionaryController {
    private final DictionaryService dictionaryService;
    private final DictionaryProfile dictionaryProfile;

    @GetMapping("/dictionaries")
    public List<DictionaryView> getDictonaries() {
        List<Dictionary> dictionaryList =  dictionaryService.getDictonaries();

        return dictionaryList.stream()
                .map(dictionaryProfile::dictionaryToDictionaryView)
                .collect(Collectors.toList());
    }

    @PostMapping("/dictionary")
    public DictionaryView postDictionary(@RequestBody DictionaryView dictionary) {
        var entity = dictionaryProfile.dictionaryViewToDictionary(dictionary);
        return dictionaryProfile.dictionaryToDictionaryView(dictionaryService.postDictionary(entity));
    }

    @DeleteMapping("/dictionary")
    public void deleteDictionary(@RequestParam(defaultValue = "string") String code) {
        dictionaryService.deleteDictionary(code);
    }
}
