package com.luxoft.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KafkaTopics {

    FAR_ARRIVAL("https://kafka-rest-000-1.dp.nlmk.com/topics/000-1.l3-transport.db.nlmk.far-arrival.0"),
    INVOICE("https://kafka-rest-000-1.dp.nlmk.com/topics/000-1.l3-transport.db.nlmk.invoice.0"),
    CURRENT_LOCATION("https://kafka-rest-000-1.dp.nlmk.com/topics/000-1.l3-transport.db.nlmk.current-location.2777"),
    WEIGHING("https://kafka-rest-000-1.dp.nlmk.com/topics/000-1.l3-transport.db.nlmk.weighing.2");

    private final String url;
}
