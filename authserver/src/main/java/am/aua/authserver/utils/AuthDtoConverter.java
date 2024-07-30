package am.aua.authserver.utils;

import am.aua.authserver.controller.model.request.UserRegistrationRequest;
import am.aua.authserver.controller.model.response.UserRegistrationResponse;
import am.aua.authserver.model.User;
import am.aua.authserver.service.model.RegisterUserData;

public class AuthDtoConverter {

    public static RegisterUserData fromDto(UserRegistrationRequest dto) {
        RegisterUserData userData = new RegisterUserData();
        userData.setAge(dto.getUserAge());
        userData.setEmail(dto.getUserEmail());
        userData.setPassword(dto.getUserPassword());
        userData.setFirstName(dto.getUserFirstName());
        userData.setLastName(dto.getUserLastName());

        return userData;
    }

    public static UserRegistrationResponse toDto(User user) {
        UserRegistrationResponse dto = new UserRegistrationResponse();
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        return dto;
    }

}
