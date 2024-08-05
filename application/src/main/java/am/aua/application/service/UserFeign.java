package am.aua.application.service;

import am.aua.application.controller.model.request.UserLoginRequest;
import am.aua.application.controller.model.request.UserRegistrationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient (
        name = "userfeign",
        url = "localhost:8080/auth"
)
public interface UserFeign {

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody UserLoginRequest user);

    @PostMapping("/register")
    ResponseEntity<?> register(@RequestBody UserRegistrationRequest user);
}
