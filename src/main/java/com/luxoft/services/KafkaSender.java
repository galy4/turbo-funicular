package com.luxoft.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.luxoft.dto.FarArrivalDto;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import nlmk.l3.transport.far_arrival.FarArrival;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.function.Supplier;

@Service
@Slf4j
public class KafkaSender {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String kafkaUrl =  "https://kafka-rest-000-1.dp.nlmk.com/topics/000-1.l3-transport.db.nlmk.far-arrival.0";
    private final Supplier<HttpHeaders> headersSupplier = ()->{
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("test_user", "test_user_test");
        headers.add("Content-type", "application/vnd.kafka.avro.v2+json");
        headers.add("Accept", "*/*");
        return headers;
    };

    public<T extends SpecificRecordBase> void sendMessage(T body){
        var dto = new RestProxyRequestDto<T>();
//        dto.setValueSchema(body.getSchema().toString());
        RestProxyRequestDto.Record<T> record = new RestProxyRequestDto.Record<>();
        record.setValue(body);
        dto.setRecords(List.of(record));

//        JsonSerializer<T> jsonSerializer = new JsonSerializer<T>();
//        log.info("Body:" +new String(jsonSerializer.serialize(kafkaUrl, body)));

        HttpEntity<RestProxyRequestDto<T>> entity = new HttpEntity<>(dto, getHeaders());
        ResponseEntity<String> response = restTemplate.postForEntity(kafkaUrl, entity, String.class);
        log.info(response.getBody());
    }

    private HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("test_user", "test_user_test");
        headers.add("Content-type", "application/vnd.kafka.avro.v2+json");
        headers.add("Accept", "*/*");
        return headers;
    }

    @Getter @Setter
    private static class RestProxyRequestDto<T extends SpecificRecordBase> {
        @JsonProperty("value_schema")
        private String valueSchema;
        @JsonProperty("records")
        private List<Record<T>> records;

        @Getter @Setter
        public static class Record<T> {
            @JsonProperty("value")
            private T value;
        }
    }


}
