package am.aua.application.controller;

import am.aua.application.controller.model.request.UserLoginRequest;
import am.aua.application.controller.model.request.UserRegistrationRequest;
import am.aua.application.service.UserFeign;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final UserFeign userFeign;

    public AuthController(UserFeign userFeign) {
        this.userFeign = userFeign;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest userDTO) {
        return userFeign.register(userDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest userDTO) {
        return userFeign.login(userDTO);
    }
}
