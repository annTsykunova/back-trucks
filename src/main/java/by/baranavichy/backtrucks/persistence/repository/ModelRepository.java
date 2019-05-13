package by.baranavichy.backtrucks.persistence.repository;

import by.baranavichy.backtrucks.persistence.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by Vanya on 28.04.2019.
 */
public interface ModelRepository extends JpaRepository<Model, Long>, EntityRepository<Model, String> {

    Optional<Model> findByNameIgnoreCase(String name);

    @Query("SELECT m.id FROM Model m WHERE m.name = :name")
    Optional<Long> findIdByName(String name);

}
