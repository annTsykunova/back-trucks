package by.baranavichy.backtrucks.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * Created by Vanya on 27.04.2019.
 */

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Manufacturer extends AbstractEntity {

    private String name;

}
