package by.baranavichy.backtrucks.importing.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Vanya on 05.05.2019.
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class ModelImportTO extends ImportTO {

    private String manufacturerName;
    private String name;
    private String engineName;
    private String productionDateStart;
    private String productionDateEnd;


}
