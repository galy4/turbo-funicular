package com.luxoft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(chain = true)
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UnloadDto {

    @JsonProperty("key_schema")
    private String keySchema;
    @JsonProperty("value_schema")
    private String valueSchema;
    @JsonProperty("records")
    private List<Record> records = null;

    @Getter @Setter
    public static class Record{
        @JsonProperty("key")
        private String key;
        @JsonProperty("value")
        private Value value;
    }

    @Getter @Setter
    public static class Value{
        @JsonProperty("ts")
        private String ts;
        @JsonProperty("op")
        private String op;
        @JsonProperty("pk")
        private Pk pk;
        @JsonProperty("data")
        private Object data;
    }

    public static class Pk{
        @JsonProperty("systemCode")
        private String systemCode;
        @JsonProperty("id")
        private String id;
    }
}
