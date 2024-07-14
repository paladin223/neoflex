package com.example.dictionary.mappings;

import com.example.dictionary.DTO.DataView;
import com.example.dictionary.model.Data;
import org.springframework.stereotype.Component;

@Component
public class DataProfile {
    public DataView dataToDataView(Data data){
        var view = new DataView();
        view.setCode(data.getCode());
        view.setValue(data.getValue());
        view.setDictionaryCode(data.getDictionary().getCode());
        return view;
    }

    public Data dataViewToData(DataView data){
        var entity = new Data();
        entity.setCode(data.getCode());
        entity.setValue(data.getValue());
        return entity;
    }
}
