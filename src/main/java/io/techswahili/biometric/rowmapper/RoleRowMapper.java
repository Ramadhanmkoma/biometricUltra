package io.techswahili.biometric.rowmapper;

import io.techswahili.biometric.domain.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
public class RoleRowMapper implements RowMapper<Role>{
    @Override
    public Role mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return Role.builder()
                .id(resultSet.getLong("id"))
                .rName(resultSet.getString("rname"))
                .permissions(resultSet.getString("permissions"))
                .build();
    }
}
