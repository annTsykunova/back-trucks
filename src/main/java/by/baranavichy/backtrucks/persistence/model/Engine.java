package by.baranavichy.backtrucks.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by Vanya on 29.04.2019.
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true, exclude = {"modelEngines"})
@ToString(exclude = {"modelEngines"})
public class Engine extends AbstractEntity {

    private String name;

    private Short displacement;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "engine")
    private Set<ModelEngine> modelEngines;

}
