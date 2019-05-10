package by.baranavichy.backtrucks.importing.service.impl;

import by.baranavichy.backtrucks.common.model.to.ModelTO;
import by.baranavichy.backtrucks.common.service.EntityService;
import by.baranavichy.backtrucks.common.service.ModelService;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.converter.impl.ModelImportConverter;
import by.baranavichy.backtrucks.importing.model.ModelImportTO;
import by.baranavichy.backtrucks.importing.parser.ImportParser;
import by.baranavichy.backtrucks.importing.parser.ModelImportParser;
import by.baranavichy.backtrucks.importing.service.ModelImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Vanya on 05.05.2019.
 */

@Service
@RequiredArgsConstructor
public class ModelImportServiceImpl
        extends ImportServiceImpl<ModelTO, ModelImportTO>
        implements ModelImportService {

    private final ModelImportParser modelImportParser;
    private final ModelService modelService;
    private final ModelImportConverter modelImportConverter;

    @Override
    protected ImportParser<ModelImportTO, ? extends Enum<?>> getParser() {
        return modelImportParser;
    }

    @Override
    protected EntityService<ModelTO> getEntityService() {
        return modelService;
    }

    @Override
    protected ImportConverter<ModelTO, ModelImportTO> getImportConverter() {
        return modelImportConverter;
    }
}
