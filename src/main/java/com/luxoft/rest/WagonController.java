package com.luxoft.rest;

import com.luxoft.dto.WagonDto;
import com.luxoft.services.FarArrivalService;
import com.luxoft.services.InvoiceService;
import com.luxoft.services.LocationService;
import com.luxoft.services.WagonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class WagonController {

    private final WagonService wagonService;

    @GetMapping("/wagon")
    private List<WagonDto> getWagon(){
        return wagonService.getWagons();
    }

    @GetMapping("/wagon/{id}")
    private ResponseEntity<WagonDto> getWagonById(@PathVariable("id") int id) {
        return new ResponseEntity<>(wagonService.getWagonById(id), HttpStatus.OK);
    }

    @PutMapping("/wagon")
    private List<WagonDto> updateWagon(@RequestBody WagonDto wagonDto){
        return wagonService.update(wagonDto);
    }

    @PostMapping("/wagon")
    private void create(@RequestBody WagonDto wagonDto){
        wagonService.create(wagonDto);
    }

    @DeleteMapping("/wagon")
    private void delete(@RequestBody WagonDto wagonDto){
         wagonService.delete(wagonDto);
    }

}
