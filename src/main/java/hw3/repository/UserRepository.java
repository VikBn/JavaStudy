package hw3.repository;

import hw3.entity.User;

import java.util.Optional;

// User repository interface
public interface UserRepository {
    void save(User user);
    Optional<User> findById(Long id);
}