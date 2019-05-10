package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.model.to.CountryTO;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.model.CountryImportTO;
import by.baranavichy.backtrucks.util.WordUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 28.04.2019.
 */

@Component
public class CountryImportConverter implements ImportConverter<CountryTO, CountryImportTO> {

    @Override
    public CountryTO toTo(CountryImportTO importTo) {
        CountryTO countryTO = new CountryTO();

        countryTO.setName(WordUtils.capitalizeEachWord(importTo.getName().toLowerCase()));
        countryTO.setCode(importTo.getCode().toUpperCase());

        return countryTO;
    }

}