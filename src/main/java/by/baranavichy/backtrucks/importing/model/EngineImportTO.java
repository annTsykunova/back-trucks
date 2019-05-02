package by.baranavichy.backtrucks.importing.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Vanya on 29.04.2019.
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class EngineImportTO extends ImportTO {

    private String name;
    private short displacement;
    private String manufacturerName;

}
