package com.luxoft.services;

import com.luxoft.dto.ResourceDto;
import com.luxoft.repository.RetrieveNsiData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final RetrieveNsiData retrieveNsiData;
    private final ResourceConvertor resourceConvertor;

    public List<String> getAll() {
        return retrieveNsiData.retrieveResourceNames();
    }

    public ResourceDto getResource(String fullName){
        return resourceConvertor.convertResource(retrieveNsiData.retrieveResourceData(fullName));
    }
}
