package by.baranavichy.backtrucks.importing.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Vanya on 28.04.2019.
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class CountryImportTO extends ImportTO {

    private String name;
    private String code;

}
