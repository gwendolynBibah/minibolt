package com.gwen.minibolt.export_data;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ExcelMetaDataDto{
    private String tableName;
    private List<String> headers;
    private List<Map<String,String>> data;
}
