package hw3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import hw3.dto.UserRegistrationDto;
import hw3.dto.UserResponseDto;
import hw3.entity.User;
import hw3.repository.UserRepository;
import hw3.service.UserService;
import hw3.service.UserServiceImpl;
import hw3.validation.UserValidator;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

public class UserServiceImplTest {

    @Test
    public void testRegisterUser() {
        // Mock dependencies
        UserValidator userValidator = mock(UserValidator.class);  // Mocking UserValidator
        UserRepository userRepository = mock(UserRepository.class); // Mocking UserRepository

        // Instantiate the service with both mocked dependencies
        UserService userService = new UserServiceImpl(userRepository, userValidator);

        // Create the user registration DTO
        UserRegistrationDto userDto = new UserRegistrationDto("test@example.com", "+1234567890", "password123", "password123");

        // Call the register method
        UserResponseDto userResponse = userService.registerUser(userDto);

        // Assertions
        assertEquals("test@example.com", userResponse.email());
        assertEquals("+1234567890", userResponse.phoneNumber());
    }

    @Test
    public void testGetUserById() {
        // Mock dependencies
        UserValidator userValidator = mock(UserValidator.class);  // Mocking UserValidator
        UserRepository userRepository = mock(UserRepository.class); // Mocking UserRepository
        UserService userService = new UserServiceImpl(userRepository, userValidator);

        // Create user mock
        User user = new User(1L, "test@example.com", "+1234567890", "password123");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Call the getUserById method
        UserResponseDto userResponse = userService.getById(1L);

        // Assertions
        assertEquals(1L, userResponse.id());
    }
}
