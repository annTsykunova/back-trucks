package by.baranavichy.backtrucks.persistence.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Vanya on 27.04.2019.
 */

@Data
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

}
