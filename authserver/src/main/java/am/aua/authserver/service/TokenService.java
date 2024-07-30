package am.aua.authserver.service;

import am.aua.authserver.model.User;
import am.aua.authserver.service.helper.TokenGenerator;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TokenService {

    public static String generateToken(User user) {
        Calendar calendar = Calendar.getInstance();
        Date issueDate = calendar.getTime();
        calendar.add(Calendar.MINUTE, 30);
        Date expiration = calendar.getTime();

        return TokenGenerator.create()
                .withAttribute("email", user.getEmail())
                .withAttribute("role", user.getRole())
                .withIssuedAt(issueDate)
                .withExpiresAt(expiration)
                .build();
    }

    public String decodeToken(String token) {
        String[] parts = token.split("\\.");
        System.out.println(Arrays.toString(parts));
        byte[] decodedHeader = Base64.getDecoder().decode(parts[0]);
        byte[] decodedPayload = Base64.getDecoder().decode(parts[1]);
        return "Header: " + new String(decodedHeader) + "\n"
                + "Payload: " + new String(decodedPayload) + "\n";
    }

    public static String extractRoleFromToken(String token) {
        String[] parts = token.split("\\.");
        String jsonString = new String(Base64.getDecoder().decode(parts[1]));
        JSONParser parser = new JSONParser(jsonString);
        LinkedHashMap json;
        try {
            json = (LinkedHashMap) parser.parse();
            return (String) json.get("role");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

}
