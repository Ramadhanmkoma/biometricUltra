package io.techswahili.biometric.service;

import io.techswahili.biometric.domain.User;
import io.techswahili.biometric.dto.UserDTO;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
public interface UserService {
    UserDTO createUser(User user);
}
