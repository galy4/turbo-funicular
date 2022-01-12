package com.luxoft.configs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.avro.specific.SpecificRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Configuration
public class KafkaConfig {

//    @Bean
//    public ObjectMapper kafkaObjectMapper() {
//        var objectMapper = new ObjectMapper();
//        objectMapper.addMixIn(SpecificRecord.class, JacksonIgnoreAvroPropertiesMixIn.class);
//        objectMapper.addMixIn(nlmk.l3.transport.far_arrival.FarArrival.class, JacksonIgnoreAvroPropertiesMixIn.class);
//        objectMapper.addMixIn(nlmk.l3.transport.far_arrival.RecordPk.class, JacksonIgnoreAvroPropertiesMixIn.class);
//        SimpleModule module = new SimpleModule();
//        module.addSerializer(Float.class, new FloatSerializer());
//        objectMapper.registerModule(module);
//        return objectMapper;
//    }

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

    //-------------Experiment---------------
    public static class FloatSerializer extends StdSerializer<Float> {

        public FloatSerializer() {
            this(null);
        }

        public FloatSerializer(Class<Float> t) {
            super(t);
        }

        @Override
        public void serialize(
                Float value, JsonGenerator jgen, SerializerProvider provider)
                throws IOException {

            jgen.writeStartObject();
            jgen.writeNumberField("float", value);
            jgen.writeEndObject();
        }
    }
}
