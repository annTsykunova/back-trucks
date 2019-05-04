package by.baranavichy.backtrucks.persistence.repository;

import by.baranavichy.backtrucks.persistence.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Vanya on 28.04.2019.
 */
public interface ModelRepository extends JpaRepository<Model, Long>, EntityRepository<Model, String> {

}
