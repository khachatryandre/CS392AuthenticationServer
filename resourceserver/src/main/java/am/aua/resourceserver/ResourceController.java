package am.aua.resourceserver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class ResourceController {

    private final AuthFeign authFeign;
    private final ResourceService resourceService;

    public ResourceController(AuthFeign authFeign, ResourceService resourceService) {
        this.authFeign = authFeign;
        this.resourceService = resourceService;
    }

    @PostMapping("/getPublicString")
    public ResponseEntity<?> getPublicString() {
        return new ResponseEntity<>(resourceService.getPublicString(), HttpStatus.OK);
    }

    @PostMapping("/getPrivateString")
    public ResponseEntity<?> getPrivateString(@RequestBody String token) {
        if (Objects.equals(authFeign.validateToken(token).getBody(), "true")) {
            return new ResponseEntity<>(resourceService.getPrivateString(), HttpStatus.OK);
        } else {
            return authFeign.validateToken(token);
        }
    }


}
