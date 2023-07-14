package io.techswahili.biometric.repository.implementation;

import io.techswahili.biometric.domain.Role;
import io.techswahili.biometric.domain.User;
import io.techswahili.biometric.exception.ApiException;
import io.techswahili.biometric.repository.RoleRepository;
import io.techswahili.biometric.repository.UserRepository;

import static io.techswahili.biometric.enumeration.RoleEnum.ROLE_LECTURER;
import static io.techswahili.biometric.query.UserQuery.*;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import static java.util.Objects.requireNonNull;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository<User> {

    private final NamedParameterJdbcTemplate jdbc;
    private final RoleRepository<Role> roleRepository;
    private final BCryptPasswordEncoder encoder;
    @Override
    public User create(User user) {
        // Check the email is unique
        if (getEmailCount(user.getEmail().trim().toLowerCase()) > 0) throw new ApiException("Email already in use. Please use a different email and try again");
        // Save the new user
        try {
            // getting the id of the user whenever we create a new account
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(user);
            jdbc.update(INSERT_USER_QUERY, parameters, holder);
            user.setId(requireNonNull(holder.getKey()).longValue());
            // Add role to the user
            roleRepository.addRoleToUser(user.getId(), ROLE_LECTURER.name());
            // Send Verification URL
            String verificationUrl = getVerificationUrl(UUID.randomUUID().toString(), ACCOUNT.getType());
            // Save URL in the verification table
            // Send Email to User with verification URL
            // Return the newly created User
            // if errors, then throw exception with proper message
        } catch (EmptyResultDataAccessException exception) {} catch (Exception exception) {}


        return null;
    }

    @Override
    public Collection<User> getList(int page, int pagesize) {
        return null;
    }

    @Override
    public User update(User data) {
        return null;
    }

    @Override
    public User getOne(Long id) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private Integer getEmailCount(String email) {
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email", email), Integer.class);
    }

    private SqlParameterSource getSqlParameterSource(User user) {
        return new MapSqlParameterSource()
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getFirstName())
                .addValue("email", user.getFirstName())
                .addValue("password", encoder.encode(user.getFirstName()));
    }

    private String getVerificationUrl(String key, ACCOUNT.getType()) {

    }
}
