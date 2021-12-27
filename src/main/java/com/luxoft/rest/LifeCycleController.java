package com.luxoft.rest;

import com.luxoft.services.FarArrivalService;
import com.luxoft.services.InvoiceService;
import com.luxoft.services.LocationService;
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

    @PostMapping("/farArrival/{invoice}")
    private void createLot(@PathVariable("invoice") String invoice) {
        farArrivalService.sendFarArrival(invoice);
    }

    @PostMapping("/invoice/{invoice}")
    private void moveLotOnSite(@PathVariable("invoice") String invoice) {
        invoiceService.sendInvoice(invoice);
    }

    @PostMapping("/currentLocation/{path}&{time}")
    private void moveLotOnSite(@PathVariable("path") String path, @PathVariable("time") String time) {
        locationService.sendCurrentLocation(path, time);
    }
}
