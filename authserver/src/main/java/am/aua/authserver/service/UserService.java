package am.aua.authserver.service;

import am.aua.authserver.exception.AuthException;
import am.aua.authserver.model.User;
import am.aua.authserver.repository.UserRepository;
import am.aua.authserver.service.helper.TokenGenerator;
import am.aua.authserver.service.model.RegisterUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(RegisterUserData user) {
        if (userRepository.getUserByEmail(user.getEmail()).isPresent()) {
            throw new AuthException("User already exists");
        }

        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(encodePassword(user.getPassword()));
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setAge(user.getAge());
        System.out.println(user.getRole());
        newUser.setRole(user.getRole());
        userRepository.save(newUser);
        return TokenService.generateToken(newUser);
    }

    public String login(String email, String password) {
        Optional<User> user = userRepository.getUserByEmail(email);
        validateUser(user, password);
        return TokenService.generateToken(user.get());
    }

    private void validateUser(Optional<User> user, String plainPassword) {
        if (user.isEmpty()) {
            throw new AuthException("User with given credentials is not found");
        }
        if (!checkPassword(plainPassword, user.get().getPassword())) {
            System.out.println("??????????" + plainPassword);
            System.out.println("//////" + user.get().getPassword());
            System.out.println("//////" + encodePassword(plainPassword));
            throw new AuthException("Credentials are not valid");
        }
    }

    private String encodePassword(String plainPassword) {
        return TokenGenerator.hashString(plainPassword);
    }

    private boolean checkPassword(String plainPassword, String encodedPassword) {
        String encodedPlainPassword = TokenGenerator.hashString(plainPassword);
        return encodedPlainPassword.equals(encodedPassword);
    }

}
