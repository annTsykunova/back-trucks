package by.baranavichy.backtrucks.importing.model.column;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Vanya on 29.04.2019.
 */

@Getter
@AllArgsConstructor
public enum EngineColumn implements RequirableColumn {

    ACTION(true),
    NAME(true),
    DISPLACEMENT(true),
    MANUFACTURER(true);

    private boolean isRequired;

}
