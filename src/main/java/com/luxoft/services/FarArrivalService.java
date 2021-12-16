package com.luxoft.services;

import com.luxoft.dto.FarArrivalDto;
import com.luxoft.repository.WagonRepository;
import com.luxoft.rest.SchemaValues;
import com.luxoft.services.messages.BuildFarArrival;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nlmk.l3.transport.far_arrival.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static com.luxoft.utils.TimeStampGenerator.getCurrentTimeStamp;
import static com.luxoft.utils.TimeStampGenerator.getDepartureDate;


@Service
@RequiredArgsConstructor
@Slf4j
public class FarArrivalService {

    private final WagonRepository wagonRepository;
    private final ResourceService resourceService;
    private final KafkaSender kafkaSender;


    private final RestTemplate restTemplate = new RestTemplate();
    private final String kafkaUrl =  "https://kafka-rest-000-1.dp.nlmk.com/topics/000-1.l3-transport.db.nlmk.far-arrival.0";

    public void sendFarArrival(String invoice){
        kafkaSender.sendMessage(buildFarArrival(invoice));
    }



    public FarArrival buildFarArrival(String invoice){
        List<RecordPositions> recordPositions = new ArrayList<>(wagonRepository.getWagonList().size());
                wagonRepository.getWagonList().forEach(w-> {
                    recordPositions.add(
                    RecordPositions.newBuilder()
                            .setWagonNum(Integer.parseInt(w.getVehicleNumber()))
                            .setWagonType(w.getWagonType())
                            .setWeightNet((float) w.getWeightNet())
                            .build()
                    );
                });

        FarArrival farArrival = FarArrival.newBuilder()
                .setOp(enum_op.I)
                .setTs(getCurrentTimeStamp())
                .setPk(RecordPk.newBuilder()
                        .setWaybillNum(invoice)
                        .setDepartureDate(getDepartureDate(5))
                        .build()
                )
                .setData(RecordData.newBuilder()
                        .setMaterialCode(resourceService.getResource().getMaterialCode())
                        .setMaterialName(resourceService.getResource().getMaterialName())
                        .setSupplierCode(resourceService.getResource().getSupplierCode())
                        .setSupplierName(resourceService.getResource().getSupplierName())
                        .setStationDepartureCode("2200")
                        .setStationArrivalCode("2")
                        .setStationArrivalName("Чугун-2")
                        .setStationDepartureName("ЗАРИНСКАЯ")
                        .setPositions(recordPositions)
                        .build()
                )
                .build();
        log.info(farArrival.toString());
        return farArrival;
    }




}
