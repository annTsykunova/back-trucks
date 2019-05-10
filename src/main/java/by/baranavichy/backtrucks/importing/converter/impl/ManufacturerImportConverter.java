package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.model.to.CountryTO;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.model.ManufacturerImportTO;
import by.baranavichy.backtrucks.util.WordUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 27.04.2019.
 */

@Component
public class ManufacturerImportConverter implements ImportConverter<ManufacturerTO, ManufacturerImportTO> {

    @Override
    public ManufacturerTO toTo(ManufacturerImportTO importTo) {
        ManufacturerTO manufacturerTO = new ManufacturerTO();
        manufacturerTO.setName(WordUtils.capitalizeEachWord(importTo.getName()));

        CountryTO countryTO = new CountryTO();
        countryTO.setCode(importTo.getCountryCode());
        manufacturerTO.setCountry(countryTO);

        return manufacturerTO;
    }

}
