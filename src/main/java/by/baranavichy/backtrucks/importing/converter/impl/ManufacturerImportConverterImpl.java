package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.model.to.CountryTO;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.importing.converter.ManufacturerImportConverter;
import by.baranavichy.backtrucks.importing.model.ManufacturerImportTO;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 27.04.2019.
 */

@Component
public class ManufacturerImportConverterImpl implements ManufacturerImportConverter {

    @Override
    public ManufacturerTO toTo(ManufacturerImportTO importTo) {
        ManufacturerTO manufacturerTO = new ManufacturerTO();

        CountryTO countryTO = new CountryTO();
        countryTO.setCode(importTo.getCountryCode());

        manufacturerTO.setName(importTo.getName());
        manufacturerTO.setCountryTO(countryTO);

        return manufacturerTO;
    }

}
