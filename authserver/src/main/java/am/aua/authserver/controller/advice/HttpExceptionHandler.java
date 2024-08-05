package am.aua.authserver.controller.advice;

import am.aua.authserver.exception.AppException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HttpExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    private ResponseEntity handleException(AppException exception) {
        return getResponse(exception);
    }


    private ResponseEntity getResponse(AppException e) {
        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("Error type: ", e.getErrorType());
        errorMessage.put("Error message: ", e.getMessage());
        return new ResponseEntity(errorMessage,  HttpStatus.BAD_REQUEST);
    }

}
