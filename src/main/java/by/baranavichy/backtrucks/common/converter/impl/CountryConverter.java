package by.baranavichy.backtrucks.common.converter.impl;

import by.baranavichy.backtrucks.common.converter.EntityTOConverter;
import by.baranavichy.backtrucks.common.model.to.CountryTO;
import by.baranavichy.backtrucks.persistence.model.Country;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 28.04.2019.
 */

@Component
public class CountryConverter implements EntityTOConverter<Country, CountryTO> {

    @Override
    public Country convertToEntity(CountryTO to) {
        Country country = new Country();
        country.setId(to.getId());
        country.setName(to.getName());
        country.setCode(to.getCode());
        return country;
    }

    @Override
    public CountryTO convertToTO(Country entity) {
        CountryTO country = new CountryTO();
        country.setId(entity.getId());
        country.setName(entity.getName());
        country.setCode(entity.getCode());
        return country;
    }
}
