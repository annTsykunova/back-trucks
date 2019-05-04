package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.model.to.CountryTO;
import by.baranavichy.backtrucks.importing.converter.CountryImportConverter;
import by.baranavichy.backtrucks.importing.model.CountryImportTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 28.04.2019.
 */

@Component
public class CountryImportConverterImpl implements CountryImportConverter {

    @Override
    public CountryTO toTo(CountryImportTO importTo) {
        CountryTO countryTO = new CountryTO();

        countryTO.setName(StringUtils.capitalize(importTo.getName().toLowerCase()));
        countryTO.setCode(importTo.getCode().toUpperCase());

        return countryTO;
    }

}