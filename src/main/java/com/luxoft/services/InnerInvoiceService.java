package com.luxoft.services;

import com.luxoft.repository.WagonRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import nlmk.l3.transport.inner_invoice.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.luxoft.utils.TimeStampGenerator.getCurrentTimeStamp;
import static com.luxoft.utils.TimeStampGenerator.getDepartureDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class InnerInvoiceService {

    private final WagonRepository wagonRepository;
    private final ResourceService resourceService;
    private final WagonService wagonService;
    private final KafkaSender kafkaSender;

    public void sendInnerInvoice(String innerInvoice){
        kafkaSender.sendMessage(buildInnerInvoice(innerInvoice), "innerinvoice");
    }

    @SneakyThrows
    private InnerInvoice buildInnerInvoice(String wayBillNum){
        wagonService.enrichWagonData(wayBillNum);
        List<RecordPositions> recordPositions = new ArrayList<>(wagonRepository.getWagonList().size());
        wagonRepository.getWagonList().forEach(w-> recordPositions.add(
                RecordPositions.newBuilder()
                        .setWagonNum(Integer.parseInt(w.getVehicleNumber()))
                        .setWagonType(w.getWagonType())
                        .setWeightNet((float) w.getWeightNet())
                        .setWaybillWagonLink(w.getWagonLink())
                        .build()
        ));
        var innerInvoice = InnerInvoice.newBuilder()
                .setOp(enum_op.I)
                .setTs(getCurrentTimeStamp())
                .setPk(RecordPk.newBuilder()
                        .setWaybillNum(wayBillNum)
                        .build()
                )
                .setData(RecordData.newBuilder()
                        .setPositions(recordPositions)
                        .setMaterialCode(resourceService.getResource().getMaterialCode())
                        .setMaterialName(resourceService.getResource().getMaterialName())
                        .setSupplierCode(resourceService.getResource().getSupplierCode())
                        .setSupplierName(resourceService.getResource().getSupplierName())
                        .setSupplierType(enum_supplierType.INTERNAL)
                        .setWeighingID(null)
                        .setStationDepartureCode("2200")
                        .setStationArrivalCode("16")
                        .setStationArrivalName("Шихтовая")
                        .setStationDepartureName("Восточная")
                        .setKceh("18")
                        .setKcehName("АГЦ")
                        .setArrivalDate(getDepartureDate(3))
                        .setDepartureDate(getDepartureDate(4))
                        .build()
                )
                .build();
        log.info(innerInvoice.toString());
        return innerInvoice;
    }


}
