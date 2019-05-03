package by.baranavichy.backtrucks.importing.service.impl;

import by.baranavichy.backtrucks.common.model.to.EngineTO;
import by.baranavichy.backtrucks.common.service.EngineService;
import by.baranavichy.backtrucks.common.service.EntityService;
import by.baranavichy.backtrucks.importing.converter.EngineImportConverter;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.model.EngineImportTO;
import by.baranavichy.backtrucks.importing.model.column.EngineColumn;
import by.baranavichy.backtrucks.importing.parser.EngineImportParser;
import by.baranavichy.backtrucks.importing.parser.ImportParser;
import by.baranavichy.backtrucks.importing.service.EngineImportService;
import org.springframework.stereotype.Service;

/**
 * Created by Vanya on 29.04.2019.
 */

@Service
public class EngineImportServiceImpl
        extends ImportServiceImpl<EngineTO, EngineImportTO>
        implements EngineImportService {

    private final EngineImportParser engineImportParser;
    private final EngineService engineService;
    private final EngineImportConverter engineImportConverter;

    public EngineImportServiceImpl(EngineImportParser engineImportParser, EngineService engineService, EngineImportConverter engineImportConverter) {
        this.engineImportParser = engineImportParser;
        this.engineService = engineService;
        this.engineImportConverter = engineImportConverter;
    }

    @Override
    protected ImportParser<EngineImportTO, EngineColumn> getParser() {
        return this.engineImportParser;
    }

    @Override
    protected EntityService<EngineTO> getEntityService() {
        return this.engineService;
    }

    @Override
    protected ImportConverter<EngineTO, EngineImportTO> getImportConverter() {
        return this.engineImportConverter;
    }

    @Override
    protected EngineTO getEnrichedTO(EngineTO toToEnrich) {
        return toToEnrich;
    }
}
