package by.baranavichy.backtrucks.common.exception;

/**
 * Created by Vanya on 10.05.2019.
 */

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
