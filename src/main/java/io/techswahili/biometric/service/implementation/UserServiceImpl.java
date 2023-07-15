package io.techswahili.biometric.service.implementation;

import io.techswahili.biometric.domain.User;
import io.techswahili.biometric.dto.UserDTO;
import io.techswahili.biometric.dtomapper.UserDTOMapper;
import io.techswahili.biometric.repository.UserRepository;
import io.techswahili.biometric.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository<User> userRepository;
    @Override
    public UserDTO createUser(User user) {
        return UserDTOMapper.fromUser(userRepository.create(user));
    }
}
