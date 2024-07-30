package am.aua.authserver.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserData {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
    private String role;

}
