package am.aua.resourceserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(
        name = "authfeign",
        url = "http://localhost:8082"
)
public interface AuthFeign {
    @PostMapping("/validateToken")
    boolean validateToken(@RequestBody String token);
}