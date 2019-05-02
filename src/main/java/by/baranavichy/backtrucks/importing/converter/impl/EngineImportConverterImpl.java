package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.model.to.EngineTO;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.importing.converter.EngineImportConverter;
import by.baranavichy.backtrucks.importing.model.EngineImportTO;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 29.04.2019.
 */

@Component
public class EngineImportConverterImpl implements EngineImportConverter {

    @Override
    public EngineTO toTo(EngineImportTO importTo) {
        EngineTO engineTO = new EngineTO();

        ManufacturerTO manufacturerTO = new ManufacturerTO();
        manufacturerTO.setName(importTo.getName());

        engineTO.setName(importTo.getName());
        engineTO.setDisplacement(importTo.getDisplacement());
        return null;
    }
}