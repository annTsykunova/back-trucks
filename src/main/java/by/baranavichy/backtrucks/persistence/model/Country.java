package by.baranavichy.backtrucks.persistence.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Vanya on 28.04.2019.
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(exclude = "manufacturers")
public class Country extends AbstractEntity {

    private String name;
    @Column(unique = true, nullable = false)
    private String code;

    @OneToMany(mappedBy = "country")
    private List<Manufacturer> manufacturers;

}


