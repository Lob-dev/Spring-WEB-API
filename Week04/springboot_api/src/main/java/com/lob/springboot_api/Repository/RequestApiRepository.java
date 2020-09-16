package com.lob.springboot_api.Repository;


import com.lob.springboot_api.dto.DaysTotalDto;
import com.lob.springboot_api.dto.RequestInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;


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
    private RowMapper<DaysTotalDto> dateRowMapper() {
        return (rs, rowNum) -> {
            DaysTotalDto daysTotalDto = new DaysTotalDto();
            daysTotalDto.setDay(rs.getString("day"));
            daysTotalDto.setCount(rs.getLong("count"));
            return daysTotalDto;
        };
    }

    public RequestInfo save(String requestCode,String userID,String createDate) {
        RequestInfo requestInfo = new RequestInfo();
        String sql = "Insert into requestinfo( requestCode, userID, createDate) values ( ?, ?, ?)";
        jdbcTemplate.update(sql , userID, requestCode, createDate);
        return requestInfo;
    }

    public List<RequestInfo> findByYear(String year){
        String sql = "select * from requestinfo where SUBSTR(createDate, 1, 2) = ?";
        List<RequestInfo> res = jdbcTemplate.query(sql, rowMapper() , year);
        return res;
    }

    public List<RequestInfo> findByMonth(String findDate) {
        String sql = "select * from requestinfo where SUBSTR(createDate, 1, 4) = ?";
        List<RequestInfo> res = jdbcTemplate.query(sql, rowMapper() , findDate);
        return res;
    }

    public List<RequestInfo> findByDays(String findDate) {
        String sql = "select * from requestinfo where SUBSTR(createDate, 1, 6) = ?";
        List<RequestInfo> res = jdbcTemplate.query(sql, rowMapper(), findDate);
        return res;
    }

    public List<RequestInfo> findByMonthAndOrgan(String findDate, String organ) {
        String sql = "SELECT * FROM requestinfo INNER JOIN user where SUBSTR(CreateDate, 1, 4) = ? " +
                "AND requestinfo.userID = user.userID AND user.HR_ORGAN = ? ";
        List<RequestInfo> res = jdbcTemplate.query(sql, rowMapper(), findDate, organ);
        return res;
    }

    public List<RequestInfo> findByOrgan(String organ) {
        String sql = "SELECT * FROM requestinfo INNER JOIN user WHERE requestinfo.userID = user.userID AND user.HR_ORGAN = ? ";
        List<RequestInfo> res = jdbcTemplate.query(sql, rowMapper(), organ);
        return res;
    }

    public List<DaysTotalDto> findByDaysAverage() {
        String sql = "SELECT MID(createdate, 1,6) day, count(*) as count from requestinfo group by day";
        List<DaysTotalDto> res = jdbcTemplate.query(sql, dateRowMapper());
        return res;
    }

    public List<DaysTotalDto> findByNotholidayAverage() {
        String sql = "SELECT MID(createdate, 1,6) day, count(*) as count from requestinfo " +
                     "where dayofweek(createdate) BETWEEN 2 and 6 group by day";
        List<DaysTotalDto> res = jdbcTemplate.query(sql, dateRowMapper());
        return res;
    }


}
