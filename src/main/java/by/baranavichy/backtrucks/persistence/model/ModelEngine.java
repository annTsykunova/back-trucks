package by.baranavichy.backtrucks.persistence.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Vanya on 29.04.2019.
 */

@Entity
@Data
public class ModelEngine implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;

    @Id
    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;

}
