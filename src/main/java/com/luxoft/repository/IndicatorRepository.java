package com.luxoft.repository;

import com.luxoft.model.Indicator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Getter @Setter
public class IndicatorRepository {

    private List<Indicator> indicatorList = new ArrayList<>();
}
