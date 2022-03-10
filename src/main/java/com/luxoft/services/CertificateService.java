package com.luxoft.services;

import com.luxoft.repository.IndicatorRepository;
import com.luxoft.repository.RetrieveNsiData;
import com.luxoft.repository.WagonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nlmk.l3.transport.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.luxoft.utils.TimeStampGenerator.getCurrentDate;
import static com.luxoft.utils.TimeStampGenerator.getCurrentTimeStamp;

@Service
@RequiredArgsConstructor
@Slf4j
public class CertificateService {
    private final WagonRepository wagonRepository;
    private final ResourceService resourceService;
    private final KafkaSender kafkaSender;
    private final IndicatorRepository indicatorRepository;
    private final RetrieveNsiData retrieveNsiData;

    public void sendCertificate() {
        kafkaSender.sendMessage(buildCertificate(), "certificates");
    }

    private SupplierCertificate buildCertificate() {
        List<RecordVehicles> vehiclesList = new ArrayList<>(wagonRepository.getWagonList().size());
        wagonRepository.getWagonList().forEach(w-> vehiclesList.add(
                RecordVehicles.newBuilder()
                    .setWaybillNum(w.getWayBillNum())
                    .setWeightNet((float)w.getWeightNet())
                    .setVehicleNum(w.getVehicleNumber())
                    .build()
                )
        );

        List<RecordQualityindicators> qualityindicators = new ArrayList<>(indicatorRepository.getIndicatorList().size());
        indicatorRepository.getIndicatorList().forEach(i-> qualityindicators.add(
                RecordQualityindicators.newBuilder()
                    .setQualityIndicatorCode(i.getCode())
                    .setQualityIndicatorMeasure(i.getMeasure())
                    .setQualityIndicatorName(i.getName())
                    .setQualityIndicatorType(i.getType().equalsIgnoreCase("CHEMICAL")?2:1)
                    .setQualityIndicatorTypeName("Число")
                    .setQualityIndicatorFormat(null)
                    .setQualityIndicatorValue(i.getValue())
                    .build()
        ));
        var certificate = SupplierCertificate.newBuilder()
                .setOp(enum_op.I)
                .setTs(getCurrentTimeStamp())
                .setPk(RecordPk.newBuilder()
                        .setId(String.valueOf(new Random().nextInt()))
                        .build()
                )
                .setData(RecordData.newBuilder()
                        .setMaterialCode(resourceService.getResource().getMaterialCode())
                        .setMaterialName(resourceService.getResource().getMaterialName())
                        .setSupplierCode(resourceService.getResource().getSupplierCode())
                        .setSupplierName(resourceService.getResource().getSupplierName())
                        .setLotNum("0206")
                        .setCertDate(getCurrentDate())
                        .setShipmentOperDate(getCurrentDate())
                        .setCertNum(String.valueOf(new Random().nextInt()))
                        .setMaterialOZM(resourceService.getResource().getCode())
                        .setStandart(retrieveNsiData.getStandardDoc(resourceService.getResource().getMaterialName()))
                        .setVehicles(vehiclesList)
                        .setQualityIndicators(qualityindicators)
                        .build()
                )
                .build();
        log.info(certificate.toString());
        return certificate;
    }
}
