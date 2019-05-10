package by.baranavichy.backtrucks.persistence.model;

import by.baranavichy.backtrucks.util.ListUtils;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Vanya on 28.04.2019.
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"modelEngines"})
public class Model extends AbstractEntity {

    @Column(nullable = false)
    private String name;
    private LocalDate productionDateStart;
    private LocalDate productionDateEnd;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "model")
    private List<ModelEngine> modelEngines = new ArrayList<>();

    public boolean addEngine(Engine engine) {
        ModelEngine modelEngine = new ModelEngine();
        modelEngine.setModel(this);
        modelEngine.setEngine(engine);

        return modelEngines.add(modelEngine);
    }

    public List<Engine> getEnginesCopy() {
        List<Engine> engines = modelEngines.stream()
                .map(ModelEngine::getEngine)
                .collect(Collectors.toList());

        return ListUtils.copyList(engines);
    }
}
