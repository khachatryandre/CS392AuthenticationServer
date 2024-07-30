package am.aua.authserver.controller.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserLoginRequest {

    private String email;
    private String password;

}
