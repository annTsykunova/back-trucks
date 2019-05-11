package by.baranavichy.backtrucks.common.model.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Vanya on 27.04.2019.
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class ManufacturerTO extends AbstractTO {

    private String name;
    private CountryTO country;

}
