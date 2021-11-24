package com.luxoft.services;

import com.luxoft.dto.WagonDto;
import com.luxoft.glossary.WagonType;
import com.luxoft.model.Wagon;
import com.luxoft.rest.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class WagonService {

//    private final List<WagonDto> wagons = new ArrayList<>();
    private final List<Wagon> wagonList = new ArrayList<>();
    private final WagonConvertor wagonConvertor;

    public WagonService() {
        wagonList.add(new Wagon(5,"10", 52.30,  WagonType.HALF.getType(), ""));
        wagonList.add(new Wagon(10,"20", 41.34,  WagonType.OK.getType(), ""));
        this.wagonConvertor = new WagonConvertor();
    }

    public List<WagonDto> getWagons() {
        return wagonConvertor.convertAll(wagonList);
    }

    public WagonDto getWagonById(int id){
            Wagon wagon =  wagonList.stream()
                    .filter(item -> id == item.getId())
                    .findAny()
                    .orElseThrow(()->new NotFoundException(Wagon.class, id));
            return wagonConvertor.convert(wagon);

    }

    public List<WagonDto> update(WagonDto wagonDto) {
        wagonList.remove(wagonList.stream().filter(w-> w.getId() == wagonDto.getId()).findFirst()
                .orElse(null));
        wagonList.add(wagonConvertor.convert(wagonDto));
        return wagonConvertor.convertAll(wagonList);
    }

    public void create(WagonDto wagonDto) {
        int maxId = wagonList.stream()
                .max(Comparator.comparing(Wagon::getId))
                .get().getId();
        wagonDto.setId(++maxId);
        wagonList.add(wagonConvertor.convert(wagonDto));
    }
}
