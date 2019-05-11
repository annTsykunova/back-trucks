package by.baranavichy.backtrucks.common.model.to;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Vanya on 29.04.2019.
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class EngineTO extends AbstractTO {

    private String name;
    private short displacement;
    private ManufacturerTO manufacturer;

//    @OneToMany(mappedBy = "engine")
//    private List<ModelEngine> modelEngines;

}
