package am.aua.application.controller;

import am.aua.application.service.ResourceFeign;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    public ResourceFeign resourceFeign;
    public ResourceController(ResourceFeign resourceFeign) {
        this.resourceFeign = resourceFeign;
    }

    @PostMapping("/getPublicString")
    public String getPublicString() {
        return resourceFeign.getPublicString();
    }

    @PostMapping("/getPrivateString")
    public String getPrivateString(@RequestBody String token) {
        return resourceFeign.getPrivateString(token);
    }
}
