package com.luxoft.rest;

import com.luxoft.dto.WagonDto;
import com.luxoft.services.WagonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WagonController {

    private final WagonService wagonService;

    @GetMapping("/wagons")
    private ResponseEntity<List<WagonDto>> getWagon(){
        return new ResponseEntity<>(wagonService.getWagons(), HttpStatus.OK);
    }

    @GetMapping("/wagon{id}")
    private ResponseEntity<WagonDto> getWagonById(@PathVariable("id") int id) throws WagonNotFoundException{
        return new ResponseEntity<>(wagonService.getWagonById(id), HttpStatus.OK);
    }

    @ExceptionHandler(WagonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private String handleWagonNotFoundException(WagonNotFoundException e){
        return e.getMessage();
    }
}
