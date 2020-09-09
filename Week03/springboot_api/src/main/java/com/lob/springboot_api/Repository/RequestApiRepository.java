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

    public RequestInfo save(RequestInfo requestInfo) {
        System.out.println("do someting");
        return null;
    }

    public List<RequestInfo> findByYear(String year){
        List<RequestInfo> result = jdbcTemplate.query("select * from requestinfo where SUBSTR(createDate, 1, 2) = ?", RowMapper() , year);
        return result;
    }

    private RowMapper<RequestInfo> RowMapper() {
        return (rs, rowNum) -> {
            RequestInfo requestInfo = new RequestInfo();
            requestInfo.setRequestID(rs.getLong("requestID"));
            requestInfo.setUserID(rs.getString("userID"));
            requestInfo.setRequestCode(rs.getString("requestCode"));
            requestInfo.setCreateDate(rs.getString("createDate"));
            return requestInfo;
        };
    }


}
