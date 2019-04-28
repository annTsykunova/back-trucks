package by.baranavichy.backtrucks.importing.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Vanya on 27.04.2019.
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class ManufacturerImportTO extends ImportTO {

    private String name;
    private String countryCode;

}
