package com.luxoft.services;

import com.luxoft.dto.WagonDto;
import com.luxoft.rest.WagonNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WagonService {

    private List<WagonDto> wagons;

    public WagonService() {
        List<WagonDto> list = new ArrayList<>();
        WagonDto wagonDto = new WagonDto();
        wagonDto.setId(5);
        wagonDto.setNumber(10);
        wagonDto.setType("Полувагон");
        wagonDto.setWeight(52.30);
        WagonDto wagonDto1 = new WagonDto();
        wagonDto1.setId(8);
        wagonDto1.setNumber(20);
        wagonDto1.setType("ОК АГЛ");
        wagonDto1.setWeight(40.82);
        list.add(wagonDto);
        list.add(wagonDto1);
        this.wagons = list;
    }

    public List<WagonDto> getWagons() {
        return wagons;
    }

    public WagonDto getWagonById(int id){
        try {
            return wagons.stream().filter(item -> id == item.getId()).findAny().get();
        }catch (Exception e){
            throw new WagonNotFoundException("No Such Wagon");
        }
    }


}
