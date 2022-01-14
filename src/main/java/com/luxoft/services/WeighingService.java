package com.luxoft.services;

import com.luxoft.repository.WagonRepository;
import lombok.RequiredArgsConstructor;


import lombok.extern.slf4j.Slf4j;
import nlmk.l3.transport.weighing.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.luxoft.utils.TimeStampGenerator.getCurrentTimeStamp;
import static com.luxoft.utils.TimeStampGenerator.getDepartureDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeighingService {
    private final WagonRepository wagonRepository;
    private final ResourceService resourceService;
    private final KafkaSender kafkaSender;

    public void sendWeighing(float brutto, float tare, String isExternal) {
        kafkaSender.sendMessage(buildWeighing(brutto, tare, isExternal), "weighing");
    }

    private Weighing buildWeighing(float brutto, float tare, String isExternal){
        String ext = isExternal.equalsIgnoreCase("internal")? isExternal.toUpperCase():"EXTERNAL";
        List<RecordPositions> recordPositions = new ArrayList<>(wagonRepository.getWagonList().size());
        wagonRepository.getWagonList().forEach(w-> recordPositions.add(
                RecordPositions.newBuilder()
                        .setWagonNum(Integer.parseInt(w.getVehicleNumber()))
                        .setWaybillWagonLink(w.getWagonLink())
                        .setSupplierType(enum_supplierType.valueOf(ext))
                        .setMaterialName(resourceService.getResource().getMaterialName())
                        .setMaterialCode(resourceService.getResource().getMaterialCode())
                        .setWeighingDate(getDepartureDate(3))
                        .setWeightGross(brutto)
                        .setWeightTare(tare)
                        .setWeightTareEmpty(tare)
                        .setTonnage(null)
                        .build()
        ));
        var weighing = Weighing.newBuilder()
                .setOp(enum_op.I)
                .setPk(RecordPk.newBuilder()
                        .setId(String.valueOf(new Random().nextInt()))
                        .build())
                .setTs(getCurrentTimeStamp())
                .setData(RecordData.newBuilder()
                        .setPositions(recordPositions)
                        .setScalesCode("5")
                        .setScalesName("Весы №5")
                        .setWeighingDocDate(getDepartureDate(3))
                        .setWeighingDocNum(String.valueOf(new Random().nextInt(10000)))
                        .setTemplateDocType("4")
                        .build()
                )
                .build();
        log.info(weighing.toString());
        return weighing;
    }
}
