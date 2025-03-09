package hw3.validation;

import hw3.dto.UserRegistrationDto;

public class UserValidator {
    public void validate(UserRegistrationDto dto) {
        if (!dto.getPassword().equals(dto.getRepeatPassword())) {
            throw new IllegalArgumentException("Passwords do not match");
        }
        if (!dto.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }
}