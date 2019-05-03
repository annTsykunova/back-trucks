package by.baranavichy.backtrucks.importing.model.column;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Vanya on 27.04.2019.
 */

@Getter
@AllArgsConstructor
public enum ManufacturerColumn implements RequirableColumn {

    ACTION(true),
    NAME(true),
    COUNTRY(true);

    private boolean isRequired;

}
