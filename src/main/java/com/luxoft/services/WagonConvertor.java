package com.luxoft.services;

import com.luxoft.dto.WagonDto;
import com.luxoft.model.Wagon;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class WagonConvertor {

    public List<WagonDto> convertAll(List<Wagon> wagons){
        List<WagonDto> wagonDtoList = new ArrayList<>(wagons.size());
        wagons.forEach(v-> wagonDtoList.add(new WagonDto(
                v.getId(),
                Integer.parseInt(v.getVehicleNumber()),
                v.getWeightNet(),
                v.getWagonType()
        )));
        return wagonDtoList;
    }

    public WagonDto convert(Wagon v){
        return new WagonDto(
                v.getId(),
                Integer.parseInt(v.getVehicleNumber()),
                v.getWeightNet(),
                v.getWagonType()
        );
    }

    public Wagon convert(WagonDto v){
        return new Wagon(
                v.getId(),
                String.valueOf(v.getNumber()),
                v.getWeight(),
                v.getType(),
                ""
        );
    }
}
