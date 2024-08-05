package am.aua.resourceserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(
        name = "authfeign",
        url = "http://localhost:8080/token"
)
public interface AuthFeign {
    @PostMapping("/validateToken")
    ResponseEntity<?> validateToken(@RequestBody String token);
}