package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.model.to.EngineTO;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.model.EngineImportTO;
import by.baranavichy.backtrucks.util.WordUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 29.04.2019.
 */

@Component
public class EngineImportConverter implements ImportConverter<EngineTO, EngineImportTO> {

    @Override
    public EngineTO toTo(EngineImportTO importTo) {
        EngineTO engineTO = new EngineTO();
        engineTO.setName(importTo.getName());
        engineTO.setDisplacement(importTo.getDisplacement());

        ManufacturerTO manufacturerTO = new ManufacturerTO();
        manufacturerTO.setName(WordUtils.capitalizeEachWord(importTo.getManufacturerName()));
        engineTO.setManufacturer(manufacturerTO);

        return engineTO;
    }
}
