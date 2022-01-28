package com.luxoft.repository;

import com.luxoft.model.Indicator;
import com.luxoft.model.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j(topic = "database")
public class RetrieveNsiData {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final ResourceDataMapper resourceDataMapper;
    private final QualityIndicatorMapper qualityIndicatorMapper;

    public Resource retrieveResourceData(String name){
        return namedParameterJdbcTemplate.queryForObject(
                "select mr.code as ozm_code, mr.full_name as material_name, mr.source_transport_code as material_code, s.code as supplier_code, s.\"name\" " +
                "as supplier_name  from material_resource mr join supplier_material_resource smr on smr.material_resource_id = mr.id \n" +
                "join supplier s on s.id = smr.supplier_id where mr.full_name = :material_name limit 1",
//                Collections.singletonMap("material_name", name), resourceDataMapper);
                Collections.singletonMap("material_name", name), (rs, i) -> new Resource(
                        rs.getString("ozm_code"),
                        rs.getString("material_name"),
                        rs.getString("material_code"),
                        rs.getString("supplier_name"),
                        rs.getString("supplier_code")
                )
        );
    }

    public Resource retrieveInnerResourceData(String name){
        return namedParameterJdbcTemplate.queryForObject(
                "select mr.full_name as material_name, mr.inside_lode_code as material_code, s.code as supplier_code, s.\"name\" \n" +
                        "as supplier_name  from material_resource mr join structure_company_material_resource smr on smr.material_resource_id = mr.id \n" +
                        "join structure_company s on s.id = smr.structure_company_id where mr.full_name = :material_name  limit 1",
                Collections.singletonMap("material_name", name), resourceDataMapper);
    }

    public List<String> retrieveResourceNames()  {
        return jdbcTemplate.queryForList("select full_name as material_name from material_resource mr join supplier_material_resource smr " +
                "on smr.material_resource_id = mr.id", String.class);
    }

    public List<String> retrieveInnerResourceNames()  {
        return jdbcTemplate.queryForList("select distinct full_name as material_name from material_resource mr join structure_company_material_resource smr \n" +
                "on smr.material_resource_id = mr.id", String.class);
    }

    public String retrievePathCode(String shortName){
        Optional<List<String>> pathcode;
        pathcode = Optional.of(namedParameterJdbcTemplate.queryForList("select code from railway where short_name = :short_name limit 1",
                Collections.singletonMap("short_name", shortName), String.class));
        return pathcode.orElse(Collections.singletonList("110236")).get(0);
    }

    public Indicator getQualityIndicatorData(String name){
        return namedParameterJdbcTemplate.queryForObject("select code, quality_indicator_type, short_name, measure from quality_indicator where \"name\" = :name",
                Collections.singletonMap("name", name), qualityIndicatorMapper);
    }

    public List<String> getIndicators() {
        return jdbcTemplate.queryForList("select \"name\" from quality_indicator", String.class);
    }

    public String getStandardDoc(String materialName) {
        Optional<List<String>> doc;
        doc = Optional.of(namedParameterJdbcTemplate.queryForList("select rd.short_name from regulatory_document rd join regulatory_document_material_resource rdmr " +
                        "on rd.id = rdmr.regulatory_document_id " +
                        "join material_resource mr on mr.id = rdmr.material_resource_id " +
                        "where mr.full_name = :materialName limit 1",
                Collections.singletonMap("materialName", materialName), String.class));
        return doc.orElse(Collections.singletonList("ТУ 0712-002-00186759-2002")).get(0);
    }
}
