package am.aua.application.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private UUID user_id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    private Role role;

    public User(String email, String password, String firstName, String lastName, Integer age, Role role) {
        this.user_id = UUID.randomUUID();
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.role = role;
    }

}
