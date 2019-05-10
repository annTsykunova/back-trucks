package by.baranavichy.backtrucks.common.exception;

import by.baranavichy.backtrucks.importing.exception.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Vanya on 03.05.2019.
 */

@Slf4j
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public HttpEntity<?> handle(ValidationException e) {
        return handle(e.getMessage(), HttpStatus.BAD_REQUEST, e);
    }

    @ExceptionHandler(Exception.class)
    public HttpEntity<?> handle(Exception e) {
        return handle("Unexpected error", HttpStatus.INTERNAL_SERVER_ERROR, e);
    }

    private ResponseEntity<?> handle(String message, HttpStatus status, Exception e) {
        log.error("Exception", e);
        return new ResponseEntity<>(message, status);
    }

}
