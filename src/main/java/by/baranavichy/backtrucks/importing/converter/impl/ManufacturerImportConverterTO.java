package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.importing.converter.ManufacturerImportConverter;
import by.baranavichy.backtrucks.importing.model.ManufacturerImportTO;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 27.04.2019.
 */

@Component
public class ManufacturerImportConverterTO implements ManufacturerImportConverter {

    @Override
    public ManufacturerTO toTo(ManufacturerImportTO importTo) {
        ManufacturerTO manufacturerTO = new ManufacturerTO();
        manufacturerTO.setName(importTo.getName());
        return manufacturerTO;
    }
}
