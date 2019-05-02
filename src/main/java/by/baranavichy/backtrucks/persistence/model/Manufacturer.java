package by.baranavichy.backtrucks.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vanya on 27.04.2019.
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Manufacturer extends AbstractEntity {

    @Column(unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "manufacturer")
    private List<Model> models;

    @OneToMany(mappedBy = "manufacturer")
    private List<Engine> engines;

}
