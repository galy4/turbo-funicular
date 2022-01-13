//package com.luxoft.services;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.TextNode;
//import com.luxoft.services.KafkaSender.RestProxyRequestDto;
//import lombok.AllArgsConstructor;
//import lombok.RequiredArgsConstructor;
//import org.apache.avro.specific.SpecificRecordBase;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Component
//@RequiredArgsConstructor
//public class MessageBatchMapper {
//
//    private final ObjectMapper objectMapper;
//
//    /**
//     * Создать объект на основании записей, которые будут отправлены в Kafka.
//     *
//     * @param records
//     *         Записи.
//     * @param <T>
//     *         Тип записей.
//     * @param key
//     *         Ключ, по которому слать в кафку.
//     *
//     * @return DTO для отправки запросов.
//     */
//    public <T extends SpecificRecordBase> RestProxyRequestDto buildBatchFromRecords(String key, List<T> records) {
//        if (CollectionUtils.isEmpty(records)) {
//            throw new IllegalArgumentException("Message list must not be empty!");
//        }
//        var record = records.get(0);
//        var schema = record.getSchema().toString();
//        var recs = records
//                .stream()
//                .map(e -> mapToMessageValue(key, e))
//                .collect(Collectors.toList());
//
//        var messagesBatchDto = new RestProxyRequestDto();
//        messagesBatchDto.setValueSchema(schema);
//        messagesBatchDto.setRecords(recs);
//        messagesBatchDto.setKeySchema(key != null ? "{\"type\":\"string\"}" : null);
//        return messagesBatchDto;
//    }
//
//    /**
//     * Создать объект на основании записей, которые будут отправлены в Kafka.
//     *
//     * @param recordMap
//     *         Записи. по ключу,
//     * @param <T>
//     *         Тип записей.
//     *
//     * @return DTO для отправки запросов.
//     */
//    public <T extends SpecificRecordBase> RestProxyRequestDto buildBatchFromRecords(Map<String, T> recordMap) {
//        var schema = new ArrayList<>(Optional.ofNullable(recordMap)
//                .orElseThrow(() -> new RuntimeException("Карта с данными пустая"))
//                .values()).get(0).getSchema().toString();
//        var recs = recordMap.entrySet().stream()
//                .filter(e -> e.getKey() != null)
//                .map(e -> mapToMessageValue(e.getKey(), e.getValue()))
//                .collect(Collectors.toList());
//        var messagesBatchDto = new RestProxyRequestDto();
//        messagesBatchDto.setValueSchema(schema);
//        messagesBatchDto.setRecords(recs);
//        messagesBatchDto.setKeySchema("{\"type\":\"string\"}");
//        return messagesBatchDto;
//    }
//
//    private <T extends SpecificRecordBase> MessageValueDto mapToMessageValue(String key, T record) {
//        try {
//            var jsonString = AvroUtils.toJsonString(record);
//            var node = objectMapper.readTree(jsonString);
//            return new MessageValueDto(node, TextNode.valueOf(key));
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//
//    @AllArgsConstructor
//    public class MessageValueDto {
//        @JsonProperty("value")
//        private JsonNode value;
//        @JsonProperty("key")
//        private JsonNode key;
//    }
//
//}
