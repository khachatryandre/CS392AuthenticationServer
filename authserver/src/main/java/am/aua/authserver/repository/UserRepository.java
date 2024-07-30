package am.aua.authserver.repository;

import am.aua.authserver.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private static UserRepository instance;
    private static List<User> users;

    private UserRepository() {
        users = new ArrayList<>();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    public void save(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public Optional<User> getUserByEmail(String email) {
        return users.stream()
                .filter(user -> email.equals(user.getEmail()))
                .findFirst();
    }
}
