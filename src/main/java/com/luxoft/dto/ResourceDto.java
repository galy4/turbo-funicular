package com.luxoft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
public class ResourceDto {

    @JsonProperty("materialName")
    private final String materialName;
    @JsonProperty("materialCode")
    private final String materialCode;
    @JsonProperty("supplierName")
    private final String supplierName;
    @JsonProperty("supplierCode")
    private final String supplierCode;
}
