package com.luxoft.rest;

import com.luxoft.dto.ResourceDto;
import com.luxoft.model.Resource;
import com.luxoft.services.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/resource/{name}")
    public ResourceDto getResource(@PathVariable("name") String name){
        return resourceService.getResource(name);
    }


}
