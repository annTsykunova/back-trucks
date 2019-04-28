package by.baranavichy.backtrucks.common.service.impl;

import by.baranavichy.backtrucks.common.converter.impl.CountryConverter;
import by.baranavichy.backtrucks.common.model.to.CountryTO;
import by.baranavichy.backtrucks.common.service.CountryService;
import by.baranavichy.backtrucks.persistence.model.Country;
import by.baranavichy.backtrucks.persistence.repository.CountryRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Vanya on 28.04.2019.
 */

@Service
public class CountryServiceImpl
        extends EntityServiceImpl<Country, CountryTO, Long>
        implements CountryService {

    public CountryServiceImpl(CountryConverter countryConverter, CountryRepository countryRepository) {
        super(countryConverter, countryRepository);
    }
}
