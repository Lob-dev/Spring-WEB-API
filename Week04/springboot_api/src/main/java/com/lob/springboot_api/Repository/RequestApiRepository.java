package com.lob.springboot_api.Repository;


import com.lob.springboot_api.dto.DaysTotalDto;
import com.lob.springboot_api.dto.ExcelFileDto;
import com.lob.springboot_api.dto.RequestInfoDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;


public class RequestApiRepository {

    private final JdbcTemplate jdbcTemplate;

    public RequestApiRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<RequestInfoDto> rowMapper() {
        return (rs, rowNum) -> {
            RequestInfoDto requestInfoDto = new RequestInfoDto.Builder()
                    .requestID(rs.getLong("requestID"))
                    .userID(rs.getString("userID"))
                    .requestCode(rs.getString("requestCode"))
                    .createDate(rs.getString("createDate"))
                    .build();
            return requestInfoDto;
        };
    }
    private RowMapper<DaysTotalDto> dateRowMapper() {
        return (rs, rowNum) -> {
            DaysTotalDto daysTotalDto = new DaysTotalDto.Builder()
            .day(rs.getString("day"))
            .count(rs.getLong("count"))
            .build();
            return daysTotalDto;
        };
    }

    private RowMapper<ExcelFileDto> excelRowMapper() {
        return (rs, rowNum) -> {
            ExcelFileDto excelFileDto = new ExcelFileDto();
            excelFileDto.setRequestID(rs.getLong("requestID"));
            excelFileDto.setRequestCode(rs.getString("requestCode"));
            excelFileDto.setUserID(rs.getString("userID"));
            excelFileDto.setUsername(rs.getString("USERNAME"));
            excelFileDto.setHr_Organ(rs.getString("HR_ORGAN"));
            excelFileDto.setPassword(rs.getString("PASSWORD"));
            excelFileDto.setCreateDate(rs.getString("createDate"));
            return excelFileDto;
        };
    }


    public RequestInfoDto save(String requestCode, String userID, String createDate) {
        RequestInfoDto requestInfoDto = new RequestInfoDto();
        String sql = "Insert into requestinfo( requestCode, userID, createDate) values ( ?, ?, ?)";
        jdbcTemplate.update(sql , userID, requestCode, createDate);
        return requestInfoDto;
    }

    public List<RequestInfoDto> findByYear(String year){
        String sql = "select * from requestinfo where SUBSTR(createDate, 1, 2) = ?";
        List<RequestInfoDto> res = jdbcTemplate.query(sql, rowMapper() , year);
        return res;
    }

    public List<RequestInfoDto> findByMonth(String findDate) {
        String sql = "select * from requestinfo where SUBSTR(createDate, 1, 4) = ?";
        List<RequestInfoDto> res = jdbcTemplate.query(sql, rowMapper() , findDate);
        return res;
    }

    public List<RequestInfoDto> findByDays(String findDate) {
        String sql = "select * from requestinfo where SUBSTR(createDate, 1, 6) = ?";
        List<RequestInfoDto> res = jdbcTemplate.query(sql, rowMapper(), findDate);
        return res;
    }

    public List<RequestInfoDto> findByMonthAndOrgan(String findDate, String organ) {
        String sql = "SELECT * FROM requestinfo INNER JOIN user where SUBSTR(CreateDate, 1, 4) = ? " +
                "AND requestinfo.userID = user.userID AND user.HR_ORGAN = ? ";
        List<RequestInfoDto> res = jdbcTemplate.query(sql, rowMapper(), findDate, organ);
        return res;
    }

    public List<RequestInfoDto> findByOrgan(String organ) {
        String sql = "SELECT * FROM requestinfo INNER JOIN user WHERE requestinfo.userID = user.userID AND user.HR_ORGAN = ? ";
        List<RequestInfoDto> res = jdbcTemplate.query(sql, rowMapper(), organ);
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

    public List<ExcelFileDto> findAll() {
        String sql = "SELECT requestinfo.requestID, requestinfo.requestCode, requestinfo.userID, " +
                "requestinfo.createDate, user.HR_ORGAN, user.USERNAME, user.PASSWORD FROM requestinfo " +
                "INNER JOIN user where requestinfo.userID = user.userID order by requestID ";
        List<ExcelFileDto> res = jdbcTemplate.query(sql, excelRowMapper());
        return res;
    }
}
