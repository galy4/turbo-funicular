package com.luxoft.repository;

import com.luxoft.glossary.WagonType;
import com.luxoft.model.Wagon;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter @Setter
public class WagonRepository {

    private List<Wagon> wagonList = new ArrayList<>();

    public WagonRepository() {
        wagonList.add(new Wagon(1,"10", 52.30,  WagonType.HALF.getType(), "", ""));
        wagonList.add(new Wagon(2,"20", 41.34,  WagonType.OK.getType(), "", ""));
    }
}
