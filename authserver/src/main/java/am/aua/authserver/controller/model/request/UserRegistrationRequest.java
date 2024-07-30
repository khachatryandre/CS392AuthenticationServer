package am.aua.authserver.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {

    private String userEmail;
    private String userPassword;
    private String userFirstName;
    private String userLastName;
    private Integer userAge;
    private String userRole;

}
