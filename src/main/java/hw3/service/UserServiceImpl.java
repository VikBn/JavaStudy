package hw3.service;

import hw3.dto.UserRegistrationDto;
import hw3.dto.UserResponseDto;
import hw3.entity.User;
import hw3.repository.UserRepository;
import hw3.validation.UserValidator;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserValidator validator;

    public UserServiceImpl(UserRepository userRepository, UserValidator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public UserResponseDto registerUser(UserRegistrationDto userRegistrationDto) {
        validator.validate(userRegistrationDto);
        User user = new User(null, userRegistrationDto.getEmail(),
                userRegistrationDto.getPhoneNumber(), userRegistrationDto.getPassword());
        userRepository.save(user);
        return new UserResponseDto(user.getId(), user.getEmail(), user.getPhoneNumber());
    }

    @Override
    public UserResponseDto getUserById(Long userId) {
        return userRepository.findById(userId)
                .map(user -> new UserResponseDto(user.getId(), user.getEmail(), user.getPhoneNumber()))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}