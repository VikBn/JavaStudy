package hw3.service;

import hw3.dto.UserRegistrationDto;
import hw3.dto.UserResponseDto;

public interface UserService {
    UserResponseDto registerUser(UserRegistrationDto userRegistrationDto);
    UserResponseDto getById(Long userId);
}