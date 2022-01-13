package com.luxoft.services;

import com.luxoft.dto.ResourceDto;
import com.luxoft.model.Resource;
import com.luxoft.repository.RetrieveNsiData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final RetrieveNsiData retrieveNsiData;
    private final ResourceConvertor resourceConvertor;


    private Resource resource;

    public List<String> getAll(String type) {
        if(type.equalsIgnoreCase("external"))
            return retrieveNsiData.retrieveResourceNames();
        else
            return retrieveNsiData.retrieveInnerResourceNames();
    }

//    public ResourceDto getResource(String fullName){
//        resourceRepository.setResource(
//                retrieveNsiData.retrieveResourceData(fullName)
//        );
//        return resourceConvertor.convertResource(resourceRepository.getResource());
//    }

    public ResourceDto getResource(String fullName, String type){
        resource = type.equalsIgnoreCase("external") ? retrieveNsiData.retrieveResourceData(fullName)
                : retrieveNsiData.retrieveInnerResourceData(fullName);
        return resourceConvertor.convertResource(resource);
    }

    public Resource getResource() {
        return resource;
    }
}
