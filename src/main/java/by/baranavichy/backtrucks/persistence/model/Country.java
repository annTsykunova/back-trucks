package by.baranavichy.backtrucks.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * Created by Vanya on 28.04.2019.
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Country extends AbstractEntity {

    private String name;
    private String code;

}


