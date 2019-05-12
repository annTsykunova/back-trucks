package by.baranavichy.backtrucks.common.enricher.impl;

import by.baranavichy.backtrucks.common.converter.impl.CountryConverter;
import by.baranavichy.backtrucks.common.enricher.EntityFetcher;
import by.baranavichy.backtrucks.persistence.model.Country;
import by.baranavichy.backtrucks.persistence.model.Manufacturer;
import by.baranavichy.backtrucks.persistence.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by Vanya on 10.05.2019.
 */

@Component
@RequiredArgsConstructor
public class ManufacturerFetcher extends EntityFetcher<Manufacturer> {

    private final CountryRepository countryRepository;
    private final CountryConverter countryConverter;

    @Override
    protected Manufacturer fetchEntity(Manufacturer manufacturer) {
        //TODO copy properties to new Object
        Optional<Country> maybeCountry = countryRepository.findByCodeIgnoreCase(manufacturer.getCountry().getCode());
        maybeCountry.ifPresent(manufacturer::setCountry);
        return manufacturer;
    }
}
