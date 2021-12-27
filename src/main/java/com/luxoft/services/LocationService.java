package com.luxoft.services;

import com.luxoft.repository.RetrieveNsiData;
import com.luxoft.repository.WagonRepository;
import com.luxoft.rest.KafkaTopics;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nlmk.l3.transport.current_location.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.luxoft.utils.TimeStampGenerator.getCurrentTimeStamp;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationService {
    private final WagonRepository wagonRepository;
    private final KafkaSender kafkaSender;
    private final RetrieveNsiData retrieveNsiData;

    public void sendCurrentLocation(String path, String time) {
        kafkaSender.sendMessage(buildCurrentLocation(path, time), KafkaTopics.CURRENT_LOCATION);
    }

    private CurrentLocation buildCurrentLocation(String path, String time){
        List<RecordPositions> recordPositions = new ArrayList<>(wagonRepository.getWagonList().size());
        wagonRepository.getWagonList().forEach(w-> recordPositions.add(
                RecordPositions.newBuilder()
                        .setWagonNum(Integer.parseInt(w.getVehicleNumber()))
                        .setWaybillWagonLink(w.getWagonLink())
                        .setWagonType(1)
                        .setElemNum(w.getId())
                        .build()
        ));
        final String pathCode = retrieveNsiData.retrievePathCode(path);
        var currentLocation = CurrentLocation.newBuilder()
                .setOp(enum_op.I)
                .setTs(getCurrentTimeStamp())
                .setPk(RecordPk.newBuilder()
                        .setId(new Random().nextLong())
                        .build()
                )
                .setData(RecordData.newBuilder()
                        .setPositions(recordPositions)
                        .setDateBegin(time)
                        .setPathCode(pathCode)
                        .setPathName(path)
                        .setStationCurrentName("Новолипецк")
                        .setStationCurrentCode("1")
                        .build()
                )
                .build();
        log.info(currentLocation.toString());
        return currentLocation;
    }
}
