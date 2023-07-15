package io.techswahili.biometric.dtomapper;

import io.techswahili.biometric.domain.User;
import io.techswahili.biometric.dto.UserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author Ramadhan Mohammed Mkoma (<a href="http://www.ramadhanmkoma.me/">RamadhanMkoma</a>)
 * @version 1.0
 * @since 07/2023
 */
@Component
public class UserDTOMapper {
    public static UserDTO fromUser(User user) {
        UserDTO userDTO = new UserDTO();
        // copy from the user to the userDTO
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        // copy from the userDTO to the user
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
