package am.aua.authserver.controller.model.request;

import lombok.Data;

@Data
public class UserRegistrationRequest {

    private String userEmail;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private Integer userAge;

}
