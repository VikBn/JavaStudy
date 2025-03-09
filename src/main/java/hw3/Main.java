package hw3;

import hw3.dto.UserRegistrationDto;
import hw3.repository.UserRepositoryJdbcImpl;
import hw3.service.UserService;
import hw3.service.UserServiceImpl;
import hw3.validation.UserValidator;

public class Main {
    public static void main(String[] args) {
        UserRepositoryJdbcImpl repository = new UserRepositoryJdbcImpl();
        UserValidator validator = new UserValidator();
        UserService userService = new UserServiceImpl(repository, validator);

        UserRegistrationDto userDto = new UserRegistrationDto();
        userDto.setEmail("test@example.com");
        userDto.setPhoneNumber("1234567890");
        userDto.setPassword("password123");
        userDto.setRepeatPassword("password123");

        var registeredUser = userService.registerUser(userDto);
        System.out.println("Registered User: " + registeredUser);
    }
}