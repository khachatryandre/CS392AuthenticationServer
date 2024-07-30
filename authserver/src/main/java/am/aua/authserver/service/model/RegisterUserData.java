package am.aua.authserver.service.model;

import lombok.Data;

@Data
public class RegisterUserData {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;

}
