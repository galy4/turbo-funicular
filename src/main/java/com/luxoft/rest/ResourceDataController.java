package com.luxoft.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.luxoft.services.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ResourceDataController {

    private final ResourceService resourceService;

    @GetMapping("/resource")
    public List<String> getAll()  {
        return resourceService.getAll();
    }


}
