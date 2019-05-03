package by.baranavichy.backtrucks.importing.model.column;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Vanya on 28.04.2019.
 */

@Getter
@AllArgsConstructor
public enum CountryColumn implements RequirableColumn {

    ACTION(true),
    NAME(true),
    CODE(true);

    private boolean isRequired;

}
