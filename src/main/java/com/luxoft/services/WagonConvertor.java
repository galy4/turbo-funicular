package com.luxoft.services;

import com.luxoft.dto.WagonDto;
import com.luxoft.model.Wagon;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WagonConvertor {

    public List<WagonDto> convertAll(List<Wagon> wagon){
        List<WagonDto> wagonDtoList = new ArrayList<>(15);
        wagon.forEach(v-> wagonDtoList.add(new WagonDto(
                v.getId(),
                Integer.parseInt(v.getVehicleNumber()),
                v.getWeightNet(),
                v.getWagonType()
        )));
        return wagonDtoList;
    }

    public List<Wagon>convertAllW(List<WagonDto> wagonDto){
        List<Wagon> wagonList = new ArrayList<>(15);
        wagonDto.forEach(v-> wagonList.add(new Wagon(
                v.getId(),
                String.valueOf(v.getNumber()),
                v.getWeight(),
                v.getType(),
                ""
        )));
        return wagonList;
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
