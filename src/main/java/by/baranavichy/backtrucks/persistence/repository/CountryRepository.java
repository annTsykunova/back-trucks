package by.baranavichy.backtrucks.persistence.repository;

import by.baranavichy.backtrucks.persistence.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Vanya on 28.04.2019.
 */

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>, EntityRepository<Country, String> {

    Optional<Country> findByCodeIgnoreCase(String code);

    @Query("SELECT c.id FROM Country c WHERE c.code = :code")
    Optional<Long> findIdByCode(@Param("code") String code);

//    @Override
//    default Optional<Country> findByUniqueIdentifier(String businessIdentifier) {
//        return findByCodeIgnoreCase(businessIdentifier);
//    };
}
