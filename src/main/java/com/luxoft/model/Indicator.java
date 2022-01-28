package com.luxoft.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Indicator {

    private String code;
    private String type;
    private String typeName;
    private String name;
    private String format;
    private String measure;
    private String value;


    public Indicator(String code, String type, String name, String measure) {
        this.code = code;
        this.type = type;
        this.name = name;
        this.measure = measure;
    }
}
