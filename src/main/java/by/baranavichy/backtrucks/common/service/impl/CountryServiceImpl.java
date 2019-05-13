package by.baranavichy.backtrucks.common.service.impl;

import by.baranavichy.backtrucks.common.converter.impl.CountryConverter;
import by.baranavichy.backtrucks.common.enricher.impl.CountryFetcher;
import by.baranavichy.backtrucks.common.model.to.CountryTO;
import by.baranavichy.backtrucks.common.service.CountryService;
import by.baranavichy.backtrucks.common.service.EntityServiceImpl;
import by.baranavichy.backtrucks.persistence.model.Country;
import by.baranavichy.backtrucks.persistence.repository.CountryRepository;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Vanya on 28.04.2019.
 */

@Service
@CacheConfig(cacheNames = {"countries"})
public class CountryServiceImpl
        extends EntityServiceImpl<Country, CountryTO, Long>
        implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryConverter countryConverter, CountryRepository countryRepository,
                              CountryFetcher countryEnricher) {
        super(countryConverter, countryRepository, countryEnricher);
        this.countryRepository = countryRepository;
    }

//    @Override
//    @Cacheable
//    public Collection<CountryTO> getAll() {
//        return super.getAll();
//    }

    @Override
    protected Optional<Long> getExistingEntityId(Country entityToSave) {
        return countryRepository.findByCodeIgnoreCase(entityToSave.getCode())
                .map(Country::getId);
    }

}
