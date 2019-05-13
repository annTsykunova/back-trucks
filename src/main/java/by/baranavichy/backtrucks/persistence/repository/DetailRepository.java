package by.baranavichy.backtrucks.persistence.repository;

import by.baranavichy.backtrucks.persistence.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Created by Vanya on 10.05.2019.
 */
public interface DetailRepository extends JpaRepository<Detail, Long>, EntityRepository<Detail, String> {

    @Query("SELECT d.id FROM Detail d WHERE d.name = :name")
    Optional<Long> findIdByName(String name);

}
