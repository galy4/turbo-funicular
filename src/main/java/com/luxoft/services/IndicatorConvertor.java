package com.luxoft.services;

import com.luxoft.dto.IndicatorDto;
import com.luxoft.model.Indicator;
import org.springframework.stereotype.Component;

@Component
public class IndicatorConvertor {

    public IndicatorDto convertIndicator(Indicator indicator){
        return new IndicatorDto(
                indicator.getName(),
                indicator.getValue()
        );
    }
}
