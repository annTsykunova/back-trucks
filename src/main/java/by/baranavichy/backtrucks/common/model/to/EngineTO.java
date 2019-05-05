package by.baranavichy.backtrucks.common.model.to;

import lombok.Data;

/**
 * Created by Vanya on 29.04.2019.
 */

@Data
public class EngineTO {

    private Long id;
    private String name;
    private short displacement;
    private ManufacturerTO manufacturer;

//    @OneToMany(mappedBy = "engine")
//    private List<ModelEngine> modelEngines;

}
