package com.luxoft.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter @Setter
public class Wagon {

    int id;
    String vehicleNumber;
    double weightNet;
    String wagonType;
    @Nullable
    String wagonLink;

    public Wagon(int id, String vehicleNumber, double weightNet, String wagonType) {
        this.id = id;
        this.vehicleNumber = vehicleNumber;
        this.weightNet = weightNet;
        this.wagonType = wagonType;
    }
}
