package by.baranavichy.backtrucks.common.model.to;

import lombok.Data;

/**
 * Created by Vanya on 27.04.2019.
 */

@Data
public class ManufacturerTO {

    private Long id;
    private String name;
    private CountryTO country;

}
