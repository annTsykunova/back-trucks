package by.baranavichy.backtrucks.persistence.repository;

import by.baranavichy.backtrucks.persistence.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Vanya on 27.04.2019.
 */

@Repository
public interface ManufacturerRepository
        extends JpaRepository<Manufacturer, Long>,
        EntityRepository<Manufacturer, String> {

    Optional<Manufacturer> findByNameIgnoreCase(String name);

    @Query("SELECT m.id FROM Manufacturer m WHERE m.name = :name")
    Optional<Long> findIdByName(String name);

}
