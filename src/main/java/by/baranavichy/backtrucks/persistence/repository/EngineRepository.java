package by.baranavichy.backtrucks.persistence.repository;

import by.baranavichy.backtrucks.persistence.model.Engine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Vanya on 29.04.2019.
 */
public interface EngineRepository extends JpaRepository<Engine, Long>, EntityRepository<Engine, String> {

    Optional<Engine> findByName(String name);

}
