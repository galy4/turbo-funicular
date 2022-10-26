package com.luxoft.services;

import com.luxoft.dto.WagonDto;
import com.luxoft.glossary.WagonType;
import com.luxoft.model.Wagon;
import com.luxoft.repository.WagonRepository;
import com.luxoft.rest.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WagonService {
    private final WagonRepository wagonRepository;
    private final WagonConvertor wagonConvertor;

    public List<WagonDto> getWagons() {
        return wagonConvertor.convertAll(wagonRepository.getWagonList());
    }

    public WagonDto getWagonById(int id){
            Wagon wagon =  wagonRepository.getWagonList().stream()
                    .filter(item -> id == item.getId())
                    .findAny()
                    .orElseThrow(()->new NotFoundException(Wagon.class, id));
            return wagonConvertor.convert(wagon);

    }

    public List<WagonDto> update(WagonDto wagonDto) {
        wagonRepository.getWagonList().remove(wagonRepository.getWagonList().stream().filter(w-> w.getId() == wagonDto.getId()).findFirst()
                .orElse(null));
        wagonRepository.getWagonList().add(wagonConvertor.convert(wagonDto));
        wagonRepository.setWagonList(wagonRepository.getWagonList().stream().sorted().collect(Collectors.toList()));
        return wagonConvertor.convertAll(wagonRepository.getWagonList());

    }

    public void create(WagonDto wagonDto) {
        int maxId = wagonRepository.getWagonList().stream()
                .max(Comparator.comparing(Wagon::getId))
                .get().getId();
        wagonDto.setId(++maxId);
        wagonRepository.getWagonList().add(wagonConvertor.convert(wagonDto));
    }

    public void enrichWagonData(String wayBillNum){
        String prefix = wayBillNum.replaceAll("[A-Za-zА-Яа-я]+", "");
        wagonRepository.getWagonList().forEach(w-> {
            w.setWagonLink(prefix + w.getVehicleNumber());
            w.setWayBillNum(wayBillNum);
        });
    }

    public void delete(WagonDto wagonDto) {
        wagonRepository.getWagonList().remove(wagonRepository.getWagonList().stream().filter(w-> w.getId() == wagonDto.getId()).findFirst()
                .orElse(null));
    }
}
