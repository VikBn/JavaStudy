package hw3.repository;
import hw3.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final Map<Long, User> database = new HashMap<>();
    private Long idCounter = 1L;

    @Override
    public void save(User user) {
        user.setId(idCounter++);
        database.put(user.getId(), user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(database.get(id));
    }
}