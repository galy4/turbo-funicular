package com.luxoft.services;

import com.luxoft.dto.WagonDto;
import com.luxoft.glossary.WagonType;
import com.luxoft.model.Wagon;
import com.luxoft.rest.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class WagonService {

    private final List<WagonDto> wagons = new ArrayList<>();
    private final List<Wagon> wagonList = new ArrayList<>();

    public WagonService() {
        wagons.add(new WagonDto(5,10, 52.30,  WagonType.HALF.getType()));
        wagons.add(new WagonDto(10,20, 41.34,  WagonType.OK.getType()));
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
