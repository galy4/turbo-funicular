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
public class FarArrivalDto {

    @JsonProperty("value_schema")
    private String valueSchema;
    @JsonProperty("records")
    private List<Record> records = null;

    @Getter @Setter
    public static class Record{
        @JsonProperty("value")
        private Value value;
    }

    @Getter @Setter
    public static class Value {
        @JsonProperty("ts")
        private String ts;
        @JsonProperty("op")
        private String op;
        @JsonProperty("pk")
        private Pk pk;
        @JsonProperty("data")
        private Data data;
    }

    @Getter @Setter
    public static class Pk{
        @JsonProperty("waybillNum")
        private String waybillNum;
        @JsonProperty("departureDate")
        private String departureDate;
    }

    @Getter @Setter
    public static class Data {
        @JsonProperty("supplierCode")
        private String supplierCode;
        @JsonProperty("stationDepartureCode")
        private String stationDepartureCode;
        @JsonProperty("stationArrivalCode")
        private String stationArrivalCode;
        @JsonProperty("stationArrivalName")
        private String stationArrivalName;
        @JsonProperty("stationDepartureName")
        private String stationDepartureName;
        @JsonProperty("supplierName")
        private String supplierName;
        @JsonProperty("materialCode")
        private String materialCode;
        @JsonProperty("materialName")
        private String materialName;
        @JsonProperty("positions")
        private List<Position> positions = null;
    }

    @Getter @Setter
    public static class Position{
        @JsonProperty("wagonNum")
        private Integer wagonNum;
        @JsonProperty("wagonType")
        private String wagonType;
        @JsonProperty("weightNet")
        private Double weightNet;
    }
}
