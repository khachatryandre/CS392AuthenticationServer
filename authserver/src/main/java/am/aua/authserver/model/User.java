package am.aua.authserver.model;

import lombok.*;

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
    private String role;

}
