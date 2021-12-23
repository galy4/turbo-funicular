package com.luxoft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class WagonDto {

    @JsonProperty("id")
    private int id;
    @JsonProperty("number")
    private int number;
    @JsonProperty("weight")
    private double weight;
    @JsonProperty("type")
    private String type;
}
