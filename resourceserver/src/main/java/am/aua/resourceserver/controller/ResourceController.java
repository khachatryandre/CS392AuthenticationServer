package am.aua.resourceserver.controller;

import am.aua.resourceserver.service.AuthFeign;
import am.aua.resourceserver.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    private final AuthFeign authFeign;
    private final ResourceService resourceService;

    @Autowired
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
        if (authFeign.validateToken(token)) {
            return new ResponseEntity<>(resourceService.getPrivateString(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}