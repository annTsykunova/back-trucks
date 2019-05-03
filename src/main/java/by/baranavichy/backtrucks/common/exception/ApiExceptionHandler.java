package by.baranavichy.backtrucks.common.exception;

import by.baranavichy.backtrucks.importing.exception.ValidationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Vanya on 03.05.2019.
 */

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public HttpEntity<?> handle(ValidationException e) {
        return handle(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<?> handle(String message, HttpStatus status) {
        return new ResponseEntity<>(message, status);
    }

}
