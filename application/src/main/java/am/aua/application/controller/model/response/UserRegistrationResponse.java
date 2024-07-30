package am.aua.application.controller.model.response;

import lombok.Data;

@Data
public class UserRegistrationResponse {

    private String firstName;
    private String lastName;
    private String email;

    @Override
    public String toString() {
        return "User %s %s is registered with email: %s".formatted(firstName, lastName, email);
    }

}
