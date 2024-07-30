package am.aua.authserver.exception;

public class InvalidTokenException extends AppException {
    public static final String defaultErrorType = "InvalidToken";
    public InvalidTokenException() {
        super("Authentication token is invalid", defaultErrorType);
    }
}
