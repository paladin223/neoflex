package com.example.dictionary.mappings;

import com.example.dictionary.DTO.DataView;
import com.example.dictionary.model.Data;
import org.springframework.stereotype.Component;

@Component
public class DataProfile {
    public DataView dataToDataView(Data dictionary){
        var view = new DataView();
        view.setCode(dictionary.getCode());
        view.setValue(dictionary.getValue());
        return view;
    }

    public Data dataViewToData(DataView dictionary){
        var entity = new Data();
        entity.setCode(dictionary.getCode());
        entity.setValue(dictionary.getValue());
        return entity;
    }
}
