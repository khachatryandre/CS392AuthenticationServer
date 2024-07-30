package am.aua.authserver.controller.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserLoginResponse {

    private String message;
    private String jwtToken;

}
