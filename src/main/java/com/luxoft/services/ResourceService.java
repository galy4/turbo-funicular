package com.luxoft.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.luxoft.model.Resource;
import com.luxoft.repository.RetrieveNsiData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final RetrieveNsiData retrieveNsiData;

    public List<String> getAll() {
        return retrieveNsiData.retrieveResources();
    }

    public Resource getResource(String fullName){
        Map<String,String> map = new HashMap<>();
        map.put("material_name", fullName);
        return retrieveNsiData.retrieveResourceData(map);
    }
}
