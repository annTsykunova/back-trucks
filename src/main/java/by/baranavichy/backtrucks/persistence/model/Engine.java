package by.baranavichy.backtrucks.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Vanya on 29.04.2019.
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Engine extends AbstractEntity {

    private String name;

    private short displacement;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "engine")
    private List<ModelEngine> modelEngines;

}
