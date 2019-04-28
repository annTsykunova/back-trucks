package by.baranavichy.backtrucks.persistence.repository;

import by.baranavichy.backtrucks.persistence.model.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Vanya on 27.04.2019.
 */

@NoRepositoryBean
public interface EntityRepository<E extends AbstractEntity, ID> extends JpaRepository<E, ID> {

}
