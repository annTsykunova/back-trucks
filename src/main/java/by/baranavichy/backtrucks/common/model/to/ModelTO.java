package by.baranavichy.backtrucks.common.model.to;

import by.baranavichy.backtrucks.util.ListUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vanya on 05.05.2019.
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class ModelTO extends AbstractTO<Long> {

    private String name;
    private LocalDate productionDateStart;
    private LocalDate productionDateEnd;

    private ManufacturerTO manufacturer;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.PRIVATE)
    private List<EngineTO> engines = new ArrayList<>();

    public boolean addEngine(EngineTO engineTO) {
        return engines.add(engineTO);
    }

    @JsonProperty("engines")
    public List<EngineTO> getEnginesCopy() {
        return ListUtils.copyList(this.engines);
    }
}
