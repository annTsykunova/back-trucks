package by.baranavichy.backtrucks.importing.service.impl;

import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.common.service.EntityService;
import by.baranavichy.backtrucks.common.service.ManufacturerService;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.converter.ManufacturerImportConverter;
import by.baranavichy.backtrucks.importing.model.ManufacturerImportTO;
import by.baranavichy.backtrucks.importing.parser.ImportParser;
import by.baranavichy.backtrucks.importing.parser.ManufacturerParser;
import by.baranavichy.backtrucks.importing.service.ManufacturerImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Vanya on 27.04.2019.
 */

@Service
@RequiredArgsConstructor
public class ManufacturerImportServiceImpl
        extends ImportServiceImpl<ManufacturerTO, ManufacturerImportTO>
        implements ManufacturerImportService {

    private final ManufacturerParser manufacturerParser;
    private final ManufacturerService manufacturerService;
    private final ManufacturerImportConverter manufacturerImportConverter;

    @Override
    protected ImportParser<ManufacturerImportTO> getParser() {
        return this.manufacturerParser;
    }

    @Override
    protected EntityService<ManufacturerTO> getEntityService() {
        return this.manufacturerService;
    }

    @Override
    protected ImportConverter<ManufacturerTO, ManufacturerImportTO> getImportConverter() {
        return this.manufacturerImportConverter;
    }

}
