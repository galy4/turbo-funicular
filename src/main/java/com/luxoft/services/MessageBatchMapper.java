//package com.luxoft.services;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.apache.avro.specific.SpecificRecordBase;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import java.util.List;
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
//    public <T extends SpecificRecordBase> MessagesBatchDto buildBatchFromRecords(String key, List<T> records) {
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
//        var messagesBatchDto = new MessagesBatchDto();
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
//    public <T extends SpecificRecordBase> MessagesBatchDto buildBatchFromRecords(Map<String, T> recordMap) {
//        var schema = new ArrayList<>(Optional.ofNullable(recordMap)
//                .orElseThrow(() -> new KafkaHttpException("Карта с данными пустая"))
//                .values()).get(0).getSchema().toString();
//        var recs = recordMap.entrySet().stream()
//                .filter(e -> e.getKey() != null)
//                .map(e -> mapToMessageValue(e.getKey(), e.getValue()))
//                .collect(Collectors.toList());
//        var messagesBatchDto = new MessagesBatchDto();
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
//            throw new KafkaHttpException(ex);
//        }
//    }
//
//}
