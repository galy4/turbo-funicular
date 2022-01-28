package com.luxoft.repository;

import com.luxoft.model.Indicator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QualityIndicatorMapper implements RowMapper<Indicator> {

    public Indicator mapRow(ResultSet rs, int i) throws SQLException {
        return new Indicator(
                rs.getString("code"),
                rs.getString("quality_indicator_type"),
                rs.getString("short_name"),
                rs.getString("measure")
        );
    }
}
