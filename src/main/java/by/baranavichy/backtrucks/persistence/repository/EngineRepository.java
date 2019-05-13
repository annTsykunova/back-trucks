package by.baranavichy.backtrucks.persistence.repository;

import by.baranavichy.backtrucks.persistence.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by Vanya on 29.04.2019.
 */
public interface EngineRepository extends JpaRepository<Engine, Long>, EntityRepository<Engine, String> {

    Optional<Engine> findByNameIgnoreCase(String name);

    @Query("SELECT e.id FROM Engine e WHERE e.name = :name")
    Optional<Long> findIdByName(String name);

}
