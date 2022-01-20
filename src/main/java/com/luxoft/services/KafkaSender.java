package com.luxoft.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.luxoft.configs.KafkaProperties;
import com.luxoft.repository.MessageRepository;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final MessageRepository messageRepository;
//    private final ObjectMapper objectMapper;
    private final String userName;
    private final String password;
//    private final MessageBatchMapper messageBatchMapper ;

    @Autowired
    private KafkaProperties kafkaTopics;


    public KafkaSender(
            @Qualifier("kafkaRestTemplate") RestTemplate restTemplate,
//            @Qualifier("kafkaObjectMapper") ObjectMapper objectMapper,
            MessageRepository messageRepository, @Value("${application.kafka.username}") String userName,
            @Value("${application.kafka.password}") String password
//            MessageBatchMapper messageBatchMapper
    ){
        this.restTemplate = restTemplate;
        this.messageRepository = messageRepository;
//        this.objectMapper = objectMapper;
        this.userName = userName;
        this.password = password;
//        this.messageBatchMapper = messageBatchMapper;
    }

    @SneakyThrows
    public <T extends SpecificRecordBase> void sendMessage(T body, String topic) {
//        var dto = new RestProxyRequestDto<T>();
//        dto.setValueSchema(body.getSchema().toString());
//        var record = new KafkaSender.Record<T>();
//        record.setValue(body);
//        dto.setRecords(List.of(record));
//
//        var bodyAsJson = objectMapper.writeValueAsString(dto);
////        if (topic.equals(KafkaTopics.INVOICE) || topic.equals(KafkaTopics.WEIGHING)) {
////            bodyAsJson = bodyAsJson.replace("\"data\":{", "\"data\":{\""+body.getClass().getPackageName()+".RecordData\":{");
////            bodyAsJson = bodyAsJson.replace("}]}}}", "}]}}}}");
////        }
//        if (topic.equalsIgnoreCase("invoice") || topic.equalsIgnoreCase("weighing")) {
//            bodyAsJson = bodyAsJson.replace("\"data\":{", "\"data\":{\""+body.getClass().getPackageName()+".RecordData\":{");
//            bodyAsJson = bodyAsJson.replace("}]}}}", "}]}}}}");
//        }
//        log.info(bodyAsJson);
//
        String avroString = AvroUtils.toJsonString(body);
//        log.info(avroString);
//        var dto = messageBatchMapper.buildBatchFromRecords("EEFAC958B41BCFE3324292D66CD244D7", Arrays.asList(body));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"value_schema\":")
                .append("\"")
                .append(body.getSchema().toString().replace("\"", "\\\""))
                .append("\"")
                .append(",\"records\": [{\"value\": ")
                .append(avroString)
                .append("}]}");

//        var request = new HttpEntity<>(dto, buildHeaders());
        var request = new HttpEntity<>(stringBuilder.toString(), buildHeaders());
        var response = restTemplate.postForEntity(extractTopicUrl(topic), request, String.class);
        log.info("RESPONSE IS: {}", response.getBody());
        messageRepository.insertMessage(stringBuilder.toString());
    }

    private HttpHeaders buildHeaders() {
        var headers = new HttpHeaders();
        headers.setBasicAuth(userName, password);
        headers.add("Content-Type", "application/vnd.kafka.avro.v2+json");
        headers.add("User-Agent", "PostmanRuntime/7.28.4");
        headers.add("Accept", "*/*");
        return headers;
    }

    private String extractTopicUrl(String topic){
        String url="about:blank";
        for(int i=0;i<kafkaTopics.getTopics().size();i++){
            if(kafkaTopics.getTopics().get(i).getName().equalsIgnoreCase(topic)) {
                url = kafkaTopics.getTopics().get(i).getUrl();
                break;
            }
        }
        return url;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
    public static class RestProxyRequestDto<T extends SpecificRecordBase> {

        @JsonProperty("value_schema")
        private String valueSchema;

        @JsonProperty("records")
        private List<Record<T>> records;

        @JsonProperty("key_schema")
        private String keySchema;
    }

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
    public static class Record<T> {

        @JsonProperty("value")
        private T value;
    }

}
