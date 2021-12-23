package com.luxoft.configs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.avro.specific.SpecificRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class KafkaConfig {

    @Bean
    public ObjectMapper kafkaObjectMapper() {
        var objectMapper = new ObjectMapper();
        objectMapper.addMixIn(SpecificRecord.class, JacksonIgnoreAvroPropertiesMixIn.class);
        objectMapper.addMixIn(nlmk.l3.transport.far_arrival.FarArrival.class, JacksonIgnoreAvroPropertiesMixIn.class);
        objectMapper.addMixIn(nlmk.l3.transport.far_arrival.RecordPk.class, JacksonIgnoreAvroPropertiesMixIn.class);
        return objectMapper;
    }

    @Bean
    public RestTemplate kafkaRestTemplate() {
        return new RestTemplate();
    }

    @SuppressWarnings("unused")
    public static abstract class JacksonIgnoreAvroPropertiesMixIn {

        @JsonIgnore
        public abstract org.apache.avro.Schema getSchema();

        @JsonIgnore
        public abstract org.apache.avro.specific.SpecificData getSpecificData();
    }
}
