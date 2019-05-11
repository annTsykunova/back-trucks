package by.baranavichy.backtrucks.persistence.repository;

import by.baranavichy.backtrucks.persistence.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Vanya on 10.05.2019.
 */
public interface DetailRepository extends JpaRepository<Detail, Long>, EntityRepository<Detail, String> {

    Optional<Detail> findByName(String name);

}
