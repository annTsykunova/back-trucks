package by.baranavichy.backtrucks.importing.model.column;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Vanya on 05.05.2019.
 */

@Getter
@AllArgsConstructor
public enum ModelColumn implements RequirableColumn {

    ACTION(true),
    MANUFACTURER(true),
    NAME(true),
    ENGINE(true),
    YEAR_START(true),
    YEAR_END(true);

    private boolean isRequired;

}
