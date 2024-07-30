package am.aua.authserver.exception;

import lombok.Getter;

public class AppException extends RuntimeException {
    @Getter
    private String errorType;

    public AppException(String message, String errorType) {
        super(message);
        this.errorType = errorType;
    }

}
