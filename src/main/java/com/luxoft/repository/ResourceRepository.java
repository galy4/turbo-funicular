package com.luxoft.repository;

import com.luxoft.model.Resource;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
@Setter
public class ResourceRepository {

    private Resource resource;

}
