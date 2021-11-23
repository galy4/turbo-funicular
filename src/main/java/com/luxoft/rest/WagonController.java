package com.luxoft.rest;

import com.luxoft.dto.UnloadDto;
import com.luxoft.dto.WagonDto;
import com.luxoft.services.WagonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

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


    //TODO
    @GetMapping("/unload")
    private void restTemplateExample(){
        RestTemplate restTemplate = new RestTemplate();
        String authToken = "dGVzdF91c2VyOnRlc3RfdXNlcl90ZXN0";
        String fooResourceUrl = "https://kafka-rest-000-1.dp.nlmk.com/topics/000-1.l3-upagp.db.nlmk.vehicle-unload-fact.1";
        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Basic " + authToken);
        headers.setBasicAuth("test_user", "test_user_test");
        headers.add("Content-type", "application/vnd.kafka.avro.v2+json");
        headers.add("Accept", "*/*");
        UnloadDto unloadDto = new UnloadDto();
        unloadDto.setKeySchema("{\"type\": \"string\"}");
        unloadDto.setValueSchema(SchemaValues.UNLOAD.getSchema());
        HttpEntity<Object> entity = new HttpEntity<>(unloadDto, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(fooResourceUrl, entity, String.class);
        log.info(response.getBody());


    }
}
