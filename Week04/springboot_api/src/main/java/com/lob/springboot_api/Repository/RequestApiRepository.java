package com.lob.springboot_api.Repository;


import com.lob.springboot_api.entity.RequestInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

public class RequestApiRepository {

    private final JdbcTemplate jdbcTemplate;

    public RequestApiRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<RequestInfo> rowMapper() {
        return (rs, rowNum) -> {
            RequestInfo requestInfo = new RequestInfo();
            requestInfo.setRequestID(rs.getLong("requestID"));
            requestInfo.setUserID(rs.getString("userID"));
            requestInfo.setRequestCode(rs.getString("requestCode"));
            requestInfo.setCreateDate(rs.getString("createDate"));
            return requestInfo;
        };
    }

    public RequestInfo save(String requestCode,String userID,String createDate) {
        RequestInfo requestInfo = new RequestInfo();
        String sql = "Insert into requestinfo( requestCode, userID, createDate) values ( ?, ?, ?)";
        jdbcTemplate.update(sql , userID, requestCode, createDate);
        return requestInfo;
    }

    public List<RequestInfo> findByYear(String year){
        List<RequestInfo> result = jdbcTemplate.query("select * from requestinfo where SUBSTR(createDate, 1, 2) = ?", rowMapper() , year);
        return result;
    }

    public List<RequestInfo> findByMonth(String findDate) {
        List<RequestInfo> result = jdbcTemplate.query("select * from requestinfo where SUBSTR(createDate, 1, 4) = ?", rowMapper() , findDate);
        return result;
    }
}
