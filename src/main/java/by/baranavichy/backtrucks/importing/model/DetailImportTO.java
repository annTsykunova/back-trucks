package by.baranavichy.backtrucks.importing.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Vanya on 10.05.2019.
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class DetailImportTO extends ImportTO {

    private String name;

}
