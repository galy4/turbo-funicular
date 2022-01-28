package com.luxoft.services;

import com.luxoft.dto.ResourceDto;
import com.luxoft.model.Resource;
import org.springframework.stereotype.Component;

@Component
public class ResourceConvertor {

    public ResourceDto convertResource(Resource resource){
        return new ResourceDto(
                resource.getMaterialName(),
                resource.getMaterialCode(),
                resource.getSupplierName(),
                resource.getSupplierCode()
        );
    }
}
