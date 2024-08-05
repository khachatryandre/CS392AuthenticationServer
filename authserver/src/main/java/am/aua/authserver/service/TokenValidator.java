package am.aua.authserver.service;

import am.aua.authserver.exception.InvalidTokenException;
import am.aua.authserver.service.helper.CustomJWTToken;
import am.aua.authserver.service.helper.TokenGenerator;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Objects;

@Service
public class TokenValidator {

    public boolean validateToken(String token) {
        String[] parts = token.split("\\.");
        CustomJWTToken customJWTToken = TokenGenerator.create(parts[0], parts[1]);
        boolean values = Objects.equals(token, customJWTToken.toString());
        Date expiration = extractExpirationDateFromToken(token);
        if (!values && expiration.compareTo(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())) > 0) {
            return true;
        } else {
            throw new InvalidTokenException();
        }
    }

    private static Date extractExpirationDateFromToken(String token) {
        String[] parts = token.split("\\.");
        String jsonString = new String(Base64.getDecoder().decode(parts[1]));
        JSONParser parser = new JSONParser(jsonString);
        LinkedHashMap json;
        Date expiration = null;
        try {
            json = (LinkedHashMap) parser.parse();
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
            expiration = dateFormat.parse((String) json.get("expires_at"));
        } catch (ParseException | java.text.ParseException u) {
            u.getMessage();
        }
        return expiration;
    }

}
