package com.luxoft.rest;

import com.luxoft.dto.ResourceDto;
import com.luxoft.model.Resource;
import com.luxoft.services.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ResourceDataController {

    private final ResourceService resourceService;

    @GetMapping("/resource/{type}")
    public List<String> getAll(@PathVariable("type") String type)  {
        return resourceService.getAll(type);
    }

    @GetMapping("/resourceData/{name}/{type}")
    public ResourceDto getResource(@PathVariable(value="name") String name,
                                   @PathVariable(value = "type") String type){
        return resourceService.getResource(name, type);
    }


}
