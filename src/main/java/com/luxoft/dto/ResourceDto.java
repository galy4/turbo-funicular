package com.luxoft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class ResourceDto {

    private final String materialName;
    private final String materialCode;
    private final String supplierName;
    private final String supplierCode;
}
