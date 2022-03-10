package com.luxoft.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import static com.luxoft.utils.TimeStampGenerator.getCurrentTimeStamp;

@Repository
@RequiredArgsConstructor
@Slf4j
public class MessageRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public int insertMessage(String message) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("message", message)
                .addValue("created_at", getCurrentTimeStamp());
        return namedParameterJdbcTemplate.update("insert into message_history (message, created_at) values (:message, :created_at)", namedParameters);
    }
}
