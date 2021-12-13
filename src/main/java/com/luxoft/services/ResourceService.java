package com.luxoft.services;

import com.luxoft.dto.ResourceDto;
import com.luxoft.model.Resource;
import com.luxoft.repository.ResourceRepository;
import com.luxoft.repository.RetrieveNsiData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final RetrieveNsiData retrieveNsiData;
    private final ResourceConvertor resourceConvertor;
    private final ResourceRepository resourceRepository;

    private Resource resource;

    public List<String> getAll() {
        return retrieveNsiData.retrieveResourceNames();
    }

//    public ResourceDto getResource(String fullName){
//        resourceRepository.setResource(
//                retrieveNsiData.retrieveResourceData(fullName)
//        );
//        return resourceConvertor.convertResource(resourceRepository.getResource());
//    }

    public ResourceDto getResource(String fullName){
        resource = retrieveNsiData.retrieveResourceData(fullName);
        return resourceConvertor.convertResource(resource);
    }

    public Resource getResource() {
        return resource;
    }
}
