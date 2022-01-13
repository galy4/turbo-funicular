package com.luxoft.configs;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "application")
@Getter @Setter
public class KafkaProperties {

    private List<Topic> topics;

    @Getter @Setter
    public static class Topic {
        String name;
        String url;
    }
}
