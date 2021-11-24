package com.luxoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;


@Getter @Setter
@AllArgsConstructor
public class Wagon {

    private int id;
    private String vehicleNumber;
    private double weightNet;
    private String wagonType;
    private String wagonLink;

}
