package by.baranavichy.backtrucks.persistence.repository;

import by.baranavichy.backtrucks.persistence.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Vanya on 28.04.2019.
 */

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>, EntityRepository<Country> {

    Optional<Country> findByName(String name);

}
