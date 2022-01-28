package com.luxoft.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;


@Getter @Setter
@AllArgsConstructor
public class Wagon implements Comparable<Wagon>{


    private int id;
    private String vehicleNumber;
    private double weightNet;
    private String wagonType;
    private String wagonLink;
    private String wayBillNum;

    @Override
    public int compareTo(Wagon w) {
        return Integer.parseInt(this.vehicleNumber) - Integer.parseInt(w.vehicleNumber);
    }

}
