package by.baranavichy.backtrucks.importing.exception;

/**
 * Created by Vanya on 03.05.2019.
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
