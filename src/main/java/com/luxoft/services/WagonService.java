package com.luxoft.services;

import com.luxoft.dto.WagonDto;
import com.luxoft.rest.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class WagonService {

    private final List<WagonDto> wagons;

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
            return wagons.stream()
                    .filter(item -> id == item.getId())
                    .findAny()
                    .orElseThrow(()->new NotFoundException(WagonDto.class, id));

    }

    public List<WagonDto> update(WagonDto wagonDto) {
        wagons.remove(wagons.stream().filter(w-> w.getId() == wagonDto.getId()).findFirst()
                .orElse(null));
        wagons.add(wagonDto);
        return wagons;
    }

    public void create(WagonDto wagonDto) {
        int maxId = wagons.stream()
                .max(Comparator.comparing(WagonDto::getId))
                .get().getId();
        wagonDto.setId(++maxId);
        wagons.add(wagonDto);
    }
}
