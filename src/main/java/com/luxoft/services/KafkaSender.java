package com.luxoft.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class KafkaSender {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final String kafkaUrl;
    private final String userName;
    private final String password;

    public KafkaSender(
            @Qualifier("kafkaRestTemplate") RestTemplate restTemplate,
            @Qualifier("kafkaObjectMapper") ObjectMapper objectMapper,
            @Value("${application.kafka.far-arrival-url}") String kafkaUrl,
            @Value("${application.kafka.username}") String userName,
            @Value("${application.kafka.password}") String password
    ) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.kafkaUrl = kafkaUrl;
        this.userName = userName;
        this.password = password;
    }

    @SneakyThrows
    public <T extends SpecificRecordBase> void sendMessage(T body) {
        var dto = new RestProxyRequestDto<T>();
        dto.setValueSchema(body.getSchema().toString());
        var record = new KafkaSender.Record<T>();
        record.setValue(body);
        dto.setRecords(List.of(record));

        var bodyAsJson = objectMapper.writeValueAsString(dto);
        var request = new HttpEntity<>(bodyAsJson, buildHeaders());
        var response = restTemplate.postForEntity(kafkaUrl, request, String.class);
        log.info("RESPONSE IS: {}", response.getBody());
    }

    private HttpHeaders buildHeaders() {
        var headers = new HttpHeaders();
        headers.setBasicAuth(userName, password);
        headers.add("Content-Type", "application/vnd.kafka.avro.v2+json");
        headers.add("User-Agent", "PostmanRuntime/7.28.4");
        headers.add("Accept", "*/*");
        return headers;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
    private static class RestProxyRequestDto<T extends SpecificRecordBase> {

        @JsonProperty("value_schema")
        private String valueSchema;

        @JsonProperty("records")
        private List<Record<T>> records;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
    public static class Record<T> {

        @JsonProperty("value")
        private T value;
    }

}
