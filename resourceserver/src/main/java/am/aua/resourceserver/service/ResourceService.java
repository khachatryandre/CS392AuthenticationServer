package am.aua.resourceserver.service;

import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    public String getPublicString() {
        return "This is a public string";
    }

    public String getPrivateString() {
        return "This is a private string";
    }
}
