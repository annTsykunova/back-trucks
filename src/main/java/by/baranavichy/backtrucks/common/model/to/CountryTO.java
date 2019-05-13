package by.baranavichy.backtrucks.common.model.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Vanya on 28.04.2019.
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class CountryTO extends AbstractTO<Long> {

    private String name;
    private String code;

}

