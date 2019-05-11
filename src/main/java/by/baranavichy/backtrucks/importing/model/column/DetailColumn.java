package by.baranavichy.backtrucks.importing.model.column;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Vanya on 10.05.2019.
 */

@Getter
@RequiredArgsConstructor
public enum DetailColumn implements RequirableColumn {

    ACTION(true),
    NAME(true);

    private final boolean isRequired;

}
