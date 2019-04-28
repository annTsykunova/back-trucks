package by.baranavichy.backtrucks.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

}
