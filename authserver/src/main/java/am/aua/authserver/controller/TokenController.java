package am.aua.authserver.controller;

import am.aua.authserver.service.TokenValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/token")
public class TokenController {

    private final TokenValidator tokenValidator;

    public TokenController(TokenValidator tokenValidator) {
        this.tokenValidator = tokenValidator;
    }

    @PostMapping("/validateToken")
    public ResponseEntity<?> validateToken(@RequestBody String token) {
        return new ResponseEntity<>(tokenValidator.validateToken(token), HttpStatus.OK);
    }
}
