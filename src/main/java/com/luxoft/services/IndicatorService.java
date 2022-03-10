package com.luxoft.services;

import com.luxoft.dto.IndicatorDto;
import com.luxoft.repository.IndicatorRepository;
import com.luxoft.repository.RetrieveNsiData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndicatorService {

    private final IndicatorRepository indicatorRepository;
    private final RetrieveNsiData retrieveNsiData;
    private final IndicatorConvertor indicatorConvertor;

    public IndicatorDto addIndicatorData(String name, String value){
        var indicator = retrieveNsiData.getQualityIndicatorData(name);
        indicator.setTypeName("Число");
        indicator.setValue(value);
        indicator.setFormat(null);
        indicatorRepository.getIndicatorList().add(indicator);
        return indicatorConvertor.convertIndicator(indicator);
    }

    public List<String> getIndicators() {
        return retrieveNsiData.getIndicators();
    }

}
