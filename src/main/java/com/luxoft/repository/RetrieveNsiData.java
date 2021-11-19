package com.luxoft.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luxoft.model.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RetrieveNsiData {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final ResourceDataMapper resourceDataMapper;

    public Resource retrieveResourceData(Map<String,String> parameters){
        Resource resource;
        resource = namedParameterJdbcTemplate.query(
                "select mr.full_name as material_name, mr.source_transport_code as material_code, s.code as supplier_code, s.\"name\" " +
                "as supplier_name  from material_resource mr join supplier_material_resource smr on smr.material_resource_id = mr.id \n" +
                "join supplier s on s.id = smr.supplier_id where mr.full_name = :material_name", parameters, resourceDataMapper)
                .get(0);
        log.info("material_code {}, material_name {}", resource.getMaterialCode(), resource.getMaterialName());
        return resource;
    }

    public List<String> retrieveResources()  {
        List<String> list;
        list = jdbcTemplate.queryForList("select full_name as material_name from material_resource mr join supplier_material_resource smr \n" +
                "on smr.material_resource_id = mr.id", String.class);
        return list;
    }
}
