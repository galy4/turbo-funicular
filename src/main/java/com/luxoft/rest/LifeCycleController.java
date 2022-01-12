package com.luxoft.rest;

import com.luxoft.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LifeCycleController {
    private final FarArrivalService farArrivalService;
    private final InvoiceService invoiceService;
    private final LocationService locationService;
    private final WeighingService weighingService;
    private final InnerInvoiceService innerInvoiceService;

    @PostMapping("/farArrival/{invoice}")
    private void createLot(@PathVariable("invoice") String invoice) {
        farArrivalService.sendFarArrival(invoice);
    }

    @PostMapping("/invoice/{invoice}")
    private void moveLotOnSite(@PathVariable("invoice") String invoice) {
        invoiceService.sendInvoice(invoice);
    }

    @PostMapping("/innerInvoice/{invoice}")
    private void createLotOnSite(@PathVariable("invoice") String invoice) {
        innerInvoiceService.sendInnerInvoice(invoice);
    }

    @PostMapping("/currentLocation/{path}&{time}")
    private void moveLotOnSite(@PathVariable("path") String path, @PathVariable("time") String time) {
        locationService.sendCurrentLocation(path, time);
    }

    @PostMapping("/weigh/{brutto}&{tare}")
    private void weighWagons(@PathVariable("brutto") float brutto, @PathVariable("tare") float tare) {
        weighingService.sendWeighing(brutto, tare);
    }
}
