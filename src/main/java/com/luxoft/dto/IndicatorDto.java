package com.luxoft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class IndicatorDto {

    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;

}
