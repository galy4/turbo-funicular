package com.luxoft.services;

import com.luxoft.repository.WagonRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import nlmk.l3.transport.invoice.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.luxoft.utils.TimeStampGenerator.getCurrentTimeStamp;
import static com.luxoft.utils.TimeStampGenerator.getDepartureDate;

@Service
@Slf4j
@RequiredArgsConstructor
public class InvoiceService {

    private final WagonRepository wagonRepository;
    private final ResourceService resourceService;
    private final WagonService wagonService;
    private final KafkaSender kafkaSender;

    public void sendInvoice(String invoice){
        kafkaSender.sendMessage(buildInvoice(invoice), "invoice");
    }

    @SneakyThrows
    private Invoice buildInvoice(String wayBillNum){
        wagonService.addWagonLinks(wayBillNum);
        List<RecordPositions> recordPositions = new ArrayList<>(wagonRepository.getWagonList().size());
        wagonRepository.getWagonList().forEach(w-> recordPositions.add(
                RecordPositions.newBuilder()
                        .setWagonNum(Integer.parseInt(w.getVehicleNumber()))
                        .setWagonType(w.getWagonType())
                        .setWeightNet((float) w.getWeightNet())
                        .setWaybillWagonLink(w.getWagonLink())
                        .build()
        ));
        var invoice = Invoice.newBuilder()
                .setOp(enum_op.I)
                .setTs(getCurrentTimeStamp())
                .setPk(RecordPk.newBuilder()
                        .setWaybillNum(wayBillNum)
                        .setDepartureDate(getDepartureDate(5))
                        .build()
                )
                .setData(RecordData.newBuilder()
                        .setPositions(recordPositions)
                        .setMaterialCode(resourceService.getResource().getMaterialCode())
                        .setMaterialName(resourceService.getResource().getMaterialName())
                        .setSupplierCode(resourceService.getResource().getSupplierCode())
                        .setSupplierName(resourceService.getResource().getSupplierName())
                        .setStationDepartureCode("2200")
                        .setStationArrivalCode("2")
                        .setStationArrivalName("Чугун-2")
                        .setStationDepartureName("ЗАРИНСКАЯ")
                        .setRecipientCode("18")
                        .setArrivalDate(getDepartureDate(3))
                        .setRecipientName(null)
                        .build()
                )
                .build();
        log.info(invoice.toString());
        return invoice;
    }

}
