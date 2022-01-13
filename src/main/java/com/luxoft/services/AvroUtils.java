package com.luxoft.services;

import org.apache.avro.io.EncoderFactory;
import org.apache.avro.io.JsonEncoder;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class AvroUtils {

    AvroUtils() {
    }

    /**
     * Сериализуем сущность в Json.
     *
     * @param record
     *         Сущность.
     * @param <T>
     *         Тип сущности.
     *
     * @return Json строка.
     */
    public static <T extends SpecificRecordBase> String toJsonString(T record) throws IOException {
        SpecificDatumWriter<T> writer = new SpecificDatumWriter<>();
        writer.setSchema(record.getSchema());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JsonEncoder jsonEncoder = EncoderFactory.get()
                .jsonEncoder(record.getSchema(), byteArrayOutputStream);
        writer.write(record, jsonEncoder);
        jsonEncoder.flush();
        return byteArrayOutputStream.toString();
    }

}
