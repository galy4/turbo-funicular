package com.luxoft.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class Resource {

    private final String materialName;
    private final String materialCode;
    private final String supplierName;
    private final String supplierCode;

}
