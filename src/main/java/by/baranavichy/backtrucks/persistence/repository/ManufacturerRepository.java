package by.baranavichy.backtrucks.persistence.repository;

import by.baranavichy.backtrucks.persistence.model.Manufacturer;
import org.springframework.stereotype.Repository;

/**
 * Created by Vanya on 27.04.2019.
 */

@Repository
public interface ManufacturerRepository extends EntityRepository<Manufacturer, Long> {


}
