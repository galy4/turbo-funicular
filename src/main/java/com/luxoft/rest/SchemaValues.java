package com.luxoft.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SchemaValues {

    UNLOAD("{\"namespace\":\"nlmk.l3.upagp.unload\",\"type\":\"record\",\"doc\":\"Факт разгрузки транспортных средств\",\"name\":\"VehicleUnloadFact\",\"fields\":[{\"name\":\"ts\",\"type\":\"string\",\"doc\":\"Дата и время передачи\"},{\"name\":\"op\",\"type\":{\"type\":\"enum\",\"name\":\"EnumOp\",\"symbols\":[\"D\",\"I\"]},\"doc\":\"Операция\"},{\"name\":\"pk\",\"type\":{\"type\":\"record\",\"name\":\"RecordPk\",\"fields\":[{\"name\":\"systemCode\",\"type\":\"string\",\"doc\":\"Код внешней системы\"},{\"name\":\"id\",\"type\":\"string\",\"doc\":\"Идентификатор факта разгрузки средств транспортировки\"}]}},{\"name\":\"data\",\"type\":[\"null\",{\"type\":\"record\",\"name\":\"RecordData\",\"fields\":[{\"name\":\"storage\",\"type\":\"string\",\"doc\":\"Код склада / бункера разгрузки материальных ресурсов\"},{\"name\":\"storageName\",\"type\":\"string\",\"doc\":\"Название склада / бункера разгрузки материальных ресурсов\"},{\"name\":\"stackId\",\"type\":[\"null\",\"string\"],\"doc\":\"Идентификатор штабеля\",\"default\":null},{\"name\":\"section\",\"type\":[\"null\",\"string\"],\"doc\":\"Код секции/ зоны / пролета для склада / бункера разгрузки материальных ресурсов\",\"default\":null},{\"name\":\"sectionName\",\"type\":[\"null\",\"string\"],\"doc\":\"Название секции/ зоны / пролета для склада / бункера разгрузки материальных ресурсов\",\"default\":null},{\"name\":\"unloadingDate\",\"type\":\"string\",\"doc\":\"Дата и время факта разгрузки средств транспортировки в формате YYYY-MM-DDThh:mm:ss?hh:mm\"},{\"name\":\"materialCode\",\"type\":\"string\",\"doc\":\"Код материального ресурса\"},{\"name\":\"materialName\",\"type\":\"string\",\"doc\":\"Наименование материала\"},{\"name\":\"vehicleType\",\"type\":\"string\",\"doc\":\"Тип средства транспортировки (1- ЖД, 2-Авто)\"},{\"name\":\"vehicleNum\",\"type\":\"string\",\"doc\":\"Номер средства транспортировки, в котором находился ресурс до выгрузки\"},{\"name\":\"weightNet\",\"type\":\"string\",\"doc\":\"Вес ресурса в средстве транспортировки\"},{\"name\":\"waybillNum\",\"type\":\"string\",\"doc\":\"Номер накладной\"}]}],\"default\":null}]}");

    private final String schema;
}
