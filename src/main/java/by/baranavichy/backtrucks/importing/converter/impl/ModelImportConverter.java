package by.baranavichy.backtrucks.importing.converter.impl;

import by.baranavichy.backtrucks.common.model.to.EngineTO;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.common.model.to.ModelTO;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.model.ModelImportTO;
import by.baranavichy.backtrucks.util.DateUtils;
import by.baranavichy.backtrucks.util.WordUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 05.05.2019.
 */

@Component
public class ModelImportConverter implements ImportConverter<ModelTO, ModelImportTO> {

    @Override
    public ModelTO toTo(ModelImportTO importTo) {
        ModelTO modelTO = new ModelTO();
        modelTO.setName(WordUtils.capitalizeEachWord(importTo.getName()));
        modelTO.setProductionDateStart(DateUtils.importStringToLocalDate(importTo.getProductionDateStart()));
        modelTO.setProductionDateEnd(DateUtils.importStringToLocalDate(importTo.getProductionDateEnd()));

        ManufacturerTO manufacturerTO = new ManufacturerTO();
        manufacturerTO.setName(WordUtils.capitalizeEachWord(importTo.getManufacturerName()));
        modelTO.setManufacturer(manufacturerTO);

        EngineTO engineTO = new EngineTO();
        engineTO.setName(importTo.getEngineName());
        modelTO.addEngine(engineTO);

        return modelTO;
    }
}
