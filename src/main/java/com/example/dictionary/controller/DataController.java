package com.example.dictionary.controller;


import com.example.dictionary.DTO.DataView;
import com.example.dictionary.mappings.DataProfile;
import com.example.dictionary.model.Data;
import com.example.dictionary.service.DataService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class DataController {
    private final DataService dataService;
    private final DataProfile dataProfile;

    @GetMapping("/dictionary/records")
    public List<DataView> getDictonaryData(@RequestParam(defaultValue = "string") String code) {
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
