package com.luxoft.services;

import com.luxoft.dto.FarArrivalDto;
import com.luxoft.repository.ResourceRepository;
import com.luxoft.repository.WagonRepository;
import com.luxoft.services.messages.BuildFarArrival;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
@Slf4j
public class FarArrivalService {

    private final ResourceRepository resourceRepository;
    private final WagonRepository wagonRepository;

    private final RestTemplate restTemplate = new RestTemplate();
    private final String kafkaUrl =  "https://kafka-rest-000-1.dp.nlmk.com/topics/000-1.l3-transport.db.nlmk.far-arrival.0";

    public void sendFarArrival(String invoice){
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("test_user", "test_user_test");
        headers.add("Content-type", "application/vnd.kafka.avro.v2+json");
        headers.add("Accept", "*/*");
        FarArrivalDto farArrivalDto = new BuildFarArrival().configureModel(
                invoice,
                resourceRepository.getResource(),
                wagonRepository.getWagonList()
        );

        HttpEntity<Object> entity = new HttpEntity<>(farArrivalDto, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(kafkaUrl, entity, String.class);
        log.info(response.getBody());
    }




}
