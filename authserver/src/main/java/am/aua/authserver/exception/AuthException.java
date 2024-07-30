package am.aua.authserver.exception;

public class AuthException extends AppException {

    private static String errorType = "Authentication error";

    private static final String defaultMessage = "Authentication error";


    public AuthException(String message) {
        super(message, errorType);
    }

    public AuthException() {
        super(defaultMessage, errorType);
    }

}
