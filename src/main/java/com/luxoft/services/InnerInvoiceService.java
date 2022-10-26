package com.luxoft.services;

import com.luxoft.repository.WagonRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import nlmk.l3.transport.inner_invoice.*;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        kafkaSender.sendMessage(buildInnerInvoice(innerInvoice, Optional.empty()), "innerinvoice");
    }

    public void sendForward(String newInvoice, String oldInvoice) {
        kafkaSender.sendMessage(buildInnerInvoice(newInvoice, Optional.of(oldInvoice)), "innerinvoice");
    }

    @SneakyThrows
    private InnerInvoice buildInnerInvoice(String wayBillNum, Optional<String> newWayBillNum){
        String supplierCode = newWayBillNum.isEmpty() ? resourceService.getResource().getSupplierCode() : "18";
        String kceh = newWayBillNum.isEmpty() ? "18":"337";
        wagonService.enrichWagonData(wayBillNum);
        List<RecordPositions> recordPositions = new ArrayList<>(wagonRepository.getWagonList().size());
        wagonRepository.getWagonList().forEach(w-> recordPositions.add(
                RecordPositions.newBuilder()
                        .setWagonNum(Integer.parseInt(w.getVehicleNumber()))
                        .setWagonType(w.getWagonType())
                        .setWeightNet((float) w.getWeightNet())
                        .setWaybillWagonLink(w.getWagonLink())
                        .setExternalWaybillWagonNumber(newWayBillNum.orElse(null))
                        .setSignArrival(null)
                        .setReserveWaybillNum(null)
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
                        .setSupplierCode(supplierCode)
                        .setSupplierName(resourceService.getResource().getSupplierName())
                        .setSupplierType(enum_supplierType.INTERNAL)
                        .setWeighingID(null)
                        .setStationDepartureCode("16")
                        .setStationArrivalCode("8")
                        .setStationArrivalName("Угольная")
                        .setStationDepartureName("Шихтовая")
                        .setKceh(kceh)
                        .setKcehName("АГЦ")
                        .setArrivalDate(getDepartureDate(3))
                        .setDepartureDate(getDepartureDate(4))
                        .setSignReserve(null)
                        .setWaybillState(1)
                        .build()
                )
                .build();
        log.info(innerInvoice.toString());
        return innerInvoice;
    }

}
