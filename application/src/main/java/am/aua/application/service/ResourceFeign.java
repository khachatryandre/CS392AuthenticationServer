package am.aua.application.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "resourceFeign",
        url = "localhost:8082"
)
public interface ResourceFeign {

    @PostMapping("/getPublicString")
    String getPublicString();

    @PostMapping("/getPrivateString")
    String getPrivateString(String token);


}
