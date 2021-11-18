package com.luxoft.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.luxoft.repository.RetrieveNsiData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final RetrieveNsiData retrieveNsiData;

    public List<String> getAll() {
        return retrieveNsiData.retrieveResources();
    }
}
