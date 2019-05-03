package by.baranavichy.backtrucks.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Vanya on 03.05.2019.
 */

@Data
@AllArgsConstructor
public class ApiException {

    private String message;
}
