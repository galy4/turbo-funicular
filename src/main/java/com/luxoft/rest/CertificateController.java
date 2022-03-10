package com.luxoft.rest;

import com.luxoft.dto.IndicatorDto;
import com.luxoft.services.CertificateService;
import com.luxoft.services.IndicatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CertificateController {

    private final IndicatorService indicatorService;
    private final CertificateService certificateService;

    @GetMapping("/indicator")
    public List<String> getAllQualityIndicators(){
        return indicatorService.getIndicators();
    }

    @GetMapping("/indicator/{name}&{value}")
    public IndicatorDto getIndicator(@PathVariable("name") String name, @PathVariable("value") String value){
        return indicatorService.addIndicatorData(name, value);
    }

    @PostMapping("/certificate")
    public void bindCertificate(){
        certificateService.sendCertificate();
    }
}
