package com.luxoft.rest;

import com.luxoft.dto.WagonDto;
import com.luxoft.services.WagonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WagonController {

    private final WagonService wagonService;

    @GetMapping("/wagon")
    private ResponseEntity<List<WagonDto>> getWagon(){
        return new ResponseEntity<>(wagonService.getWagon(), HttpStatus.OK);
    }
}
