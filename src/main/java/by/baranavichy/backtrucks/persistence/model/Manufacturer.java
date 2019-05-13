package by.baranavichy.backtrucks.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Vanya on 27.04.2019.
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = {"models"})
public class Manufacturer extends AbstractEntity<Long> {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "manufacturer")
    private List<Model> models;

    @OneToMany(mappedBy = "manufacturer")
    private List<Engine> engines;

}
