package by.baranavichy.backtrucks.common.enricher.impl;

import by.baranavichy.backtrucks.common.converter.impl.CountryConverter;
import by.baranavichy.backtrucks.common.converter.impl.ManufacturerConverter;
import by.baranavichy.backtrucks.common.enricher.ToEnricher;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.persistence.model.Country;
import by.baranavichy.backtrucks.persistence.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created by Vanya on 10.05.2019.
 */

@Component
@RequiredArgsConstructor
public class ManufacturerEnricher extends ToEnricher<ManufacturerTO> {

    private final CountryRepository countryRepository;
    private final ManufacturerConverter manufacturerConverter;
    private final CountryConverter countryConverter;

    @Override
    protected ManufacturerTO enrichTo(ManufacturerTO toToEnrich) {
        //TODO copy properties to new Object
        Optional<Country> maybeCountry = countryRepository.findByCodeIgnoreCase(toToEnrich.getCountry().getCode());
        maybeCountry.map(countryConverter::convertToTO)
                .ifPresent(toToEnrich::setCountry);
        return toToEnrich;
    }
}
