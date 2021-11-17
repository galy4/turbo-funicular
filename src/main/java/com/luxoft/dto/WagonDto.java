package com.luxoft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WagonDto {

    private int id;
    private int number;
    private double weight;
    private String type;
}
