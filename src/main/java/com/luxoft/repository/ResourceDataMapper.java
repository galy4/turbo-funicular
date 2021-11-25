package com.luxoft.repository;

import com.luxoft.model.Resource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ResourceDataMapper implements RowMapper<Resource> {

    @Override
    public Resource mapRow(ResultSet rs, int i) throws SQLException {
        return new Resource(
                rs.getString("material_name"),
                rs.getString("material_code"),
                rs.getString("supplier_name"),
                rs.getString("supplier_code"));
        }
}
