package com.luxoft.glossary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public enum WagonType {

    HALF("Полувагон"),
    OK("ОК АГЛ"),
    CS("ЦС");

    private final String type;
}
