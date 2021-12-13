package com.luxoft.repository;

import com.luxoft.model.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RetrieveNsiData {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//    private final ResourceDataMapper resourceDataMapper;

    public Resource retrieveResourceData(String name){
        Resource resource = namedParameterJdbcTemplate.queryForObject(
                "select mr.full_name as material_name, mr.source_transport_code as material_code, s.code as supplier_code, s.\"name\" " +
                "as supplier_name  from material_resource mr join supplier_material_resource smr on smr.material_resource_id = mr.id \n" +
                "join supplier s on s.id = smr.supplier_id where mr.full_name = :material_name limit 1",
//                Collections.singletonMap("material_name", name), resourceDataMapper);
                Collections.singletonMap("material_name", name), (rs, i) -> new Resource(
                        rs.getString("material_name"),
                        rs.getString("material_code"),
                        rs.getString("supplier_name"),
                        rs.getString("supplier_code")
                )
        );
        log.info("material_code {}, material_name {}", resource.getMaterialCode(), resource.getMaterialName());
        return resource;
    }

    public List<String> retrieveResourceNames()  {
        return jdbcTemplate.queryForList("select full_name as material_name from material_resource mr join supplier_material_resource smr " +
                "on smr.material_resource_id = mr.id", String.class);
    }
}
