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

//    private final List<WagonDto> wagons = new ArrayList<>();
//    private final List<Wagon> wagonList = new ArrayList<>();
    private final WagonRepository wagonRepository;
    private final WagonConvertor wagonConvertor;

//    public WagonService() {
////        wagonRepository.getWagonList().add(new Wagon(5,"10", 52.30,  WagonType.HALF.getType(), ""));
////        wagonRepository.getWagonList().add(new Wagon(10,"20", 41.34,  WagonType.OK.getType(), ""));
//        this.wagonConvertor = new WagonConvertor();
//    }

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

    public void addWagonLinks(String wayBillNum){
        String prefix = wayBillNum.replaceAll("[A-Za-zА-Яа-я]+", "");
        wagonRepository.getWagonList().forEach(w->
                w.setWagonLink(prefix + w.getVehicleNumber())
        );
    }
}
