package by.baranavichy.backtrucks.common.model.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Vanya on 10.05.2019.
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class DetailTO extends AbstractTO {

    private String name;

}
