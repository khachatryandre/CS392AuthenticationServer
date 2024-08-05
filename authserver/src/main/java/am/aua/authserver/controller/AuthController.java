package am.aua.authserver.controller;

import am.aua.authserver.controller.model.request.UserLoginRequest;
import am.aua.authserver.controller.model.request.UserRegistrationRequest;
import am.aua.authserver.controller.model.response.UserLoginResponse;
import am.aua.authserver.service.TokenValidator;
import am.aua.authserver.service.UserService;
import am.aua.authserver.utils.AuthDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final TokenValidator tokenValidator;

    public AuthController(UserService userService, TokenValidator tokenValidator) {
        this.userService = userService;
        this.tokenValidator = tokenValidator;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationRequest userDTO) {
        String jwtToken = userService.registerUser(AuthDtoConverter.fromDto(userDTO));
        return new ResponseEntity<>(new UserLoginResponse("Registration Successful", jwtToken), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest userDTO) {
        String jwtToken = userService.login(userDTO.getEmail(), userDTO.getPassword());
        return new ResponseEntity<>(new UserLoginResponse("Login Successful", jwtToken), HttpStatus.CREATED);
    }

    @PostMapping("/validateToken")
    public ResponseEntity<?> validateToken(@RequestBody String token) {
        return new ResponseEntity<>(tokenValidator.validateToken(token), HttpStatus.OK);
    }

}
