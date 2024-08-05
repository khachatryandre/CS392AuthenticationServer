package am.aua.resourceserver;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(
        name = "userfeign",
        url = "localhost:8080/auth"
)
public interface AuthFeign {


    @PostMapping("/validateToken")
    ResponseEntity<?> validateToken(@RequestBody String token);

}
