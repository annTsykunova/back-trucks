package by.baranavichy.backtrucks.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by Vanya on 10.05.2019.
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Detail extends AbstractEntity<Long> {

    @Column(nullable = false)
    private String name;

}
