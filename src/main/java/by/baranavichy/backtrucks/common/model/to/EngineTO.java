package by.baranavichy.backtrucks.common.model.to;

import lombok.Data;

/**
 * Created by Vanya on 29.04.2019.
 */

@Data
public class EngineTO {

    private String name;

    private short displacement;

    private ManufacturerTO manufacturerTO;

//    @OneToMany(mappedBy = "engine")
//    private List<ModelEngine> modelEngines;

}
