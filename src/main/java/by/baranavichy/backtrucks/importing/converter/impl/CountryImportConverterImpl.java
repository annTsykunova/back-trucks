package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.model.to.CountryTO;
import by.baranavichy.backtrucks.importing.converter.CountryImportConverter;
import by.baranavichy.backtrucks.importing.model.CountryImportTO;
import by.baranavichy.backtrucks.util.WordUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 28.04.2019.
 */

@Component
public class CountryImportConverterImpl implements CountryImportConverter {

    @Override
    public CountryTO toTo(CountryImportTO importTo) {
        CountryTO countryTO = new CountryTO();

        countryTO.setName(WordUtils.capitalizeEachWord(importTo.getName().toLowerCase()));
        countryTO.setCode(importTo.getCode().toUpperCase());

        return countryTO;
    }

}