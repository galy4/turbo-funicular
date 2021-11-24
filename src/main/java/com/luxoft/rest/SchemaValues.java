package com.luxoft.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SchemaValues {

    FAR_ARRIVAL_SCHEMA("{\"type\":\"record\",\"name\":\"FarArrival\",\"namespace\":\"nlmk.l3.transport.far_arrival\",\"doc\":\"Накладная Дальний подход\",\"fields\":[{\"name\":\"ts\",\"type\":\"string\",\"doc\":\"Дата и время передачи\"},{\"name\":\"op\",\"type\":{\"type\":\"enum\",\"name\":\"enum_op\",\"symbols\":[\"I\",\"U\"]},\"doc\":\"Код операции\"},{\"name\":\"pk\",\"type\":{\"type\":\"record\",\"name\":\"RecordPk\",\"fields\":[{\"name\":\"waybillNum\",\"type\":\"string\",\"doc\":\"Номер накладной\"},{\"name\":\"departureDate\",\"type\":\"string\",\"doc\":\"Дата отправления (в формате YYYY-MM-DDThh:mm:ss+hh:mm)\"}]},\"doc\":\"Ключ объекта\"},{\"name\":\"data\",\"type\":{\"type\":\"record\",\"name\":\"RecordData\",\"doc\":\"Данные операции\",\"fields\":[{\"name\":\"stationDepartureCode\",\"type\":\"string\",\"doc\":\"Код станции отправления\"},{\"name\":\"stationDepartureName\",\"type\":\"string\",\"doc\":\"Название станции отправления\"},{\"name\":\"stationArrivalCode\",\"type\":\"string\",\"doc\":\"Код станции назначения\"},{\"name\":\"stationArrivalName\",\"type\":\"string\",\"doc\":\"Название станции назначения\"},{\"name\":\"supplierCode\",\"type\":\"string\",\"doc\":\"Код грузоотправителя\"},{\"name\":\"supplierName\",\"type\":\"string\",\"doc\":\"Наименование грузоотправителя\"},{\"name\":\"materialCode\",\"type\":\"string\",\"doc\":\"Код груза\"},{\"name\":\"materialName\",\"type\":\"string\",\"doc\":\"Наименование груза\"},{\"name\":\"positions\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"RecordPositions\",\"fields\":[{\"name\":\"wagonNum\",\"type\":\"int\",\"doc\":\"Номер вагона\"},{\"name\":\"wagonType\",\"type\":\"string\",\"doc\":\"Тип вагона\"},{\"name\":\"weightNet\",\"type\":\"float\",\"doc\":\"Вес груза, т\"}]}},\"doc\":\"Позиции накладной\"}]}}]}");

    private final String schema;
}
