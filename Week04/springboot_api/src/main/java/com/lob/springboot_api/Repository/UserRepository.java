package com.lob.springboot_api.Repository;

import com.lob.springboot_api.dto.UserDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<UserDto> rowMapper() {
        return (rs, rowNum) -> {
            UserDto user = new UserDto();
            user.setUserID(rs.getString("userID"));
            user.setHr_Organ(rs.getString("HR_ORGAN"));
            user.setUsername(rs.getString("username"));
            return user;
        };
    }

    public UserDto save(UserDto userDto) {
        String sql = "Insert into user( userID, HR_ORGAN, username, password) values ( ?, ?, ?, ?)";
        jdbcTemplate.update(sql , userDto.getUserID(), userDto.getHr_Organ(), userDto.getUsername(), userDto.getPassword());
        return userDto;
    }


    public List<UserDto> findByUser(String userID) {
        String sql = "SELECT * FROM user WHERE userID = ?";
        List<UserDto> res = jdbcTemplate.query(sql, rowMapper(), userID);
        return res;
    }

    public Optional<UserDto> findByUserAndPassword(String userID, String password) {
        String sql = "SELECT * FROM user WHERE userID = ? And Password = ?";
        List<UserDto> res = jdbcTemplate.query(sql, rowMapper(), userID, password);
        return res.stream().findAny();
    }
}
