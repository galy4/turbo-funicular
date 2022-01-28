package com.luxoft.rest;

import com.luxoft.dto.IndicatorDto;
import com.luxoft.services.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService certificateService;

    @GetMapping("/indicator")
    public List<String> getAllQualityIndicators(){
        return certificateService.getIndicators();
    }

    @GetMapping("/indicator/{name}&{value}")
    public IndicatorDto getIndicator(@PathVariable("name") String name, @PathVariable("value") String value){
        return certificateService.addIndicatorData(name, value);
    }
}
