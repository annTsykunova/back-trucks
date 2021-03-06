package by.baranavichy.backtrucks.importing.service.impl;

import by.baranavichy.backtrucks.common.converter.impl.CountryConverter;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.common.service.EntityService;
import by.baranavichy.backtrucks.common.service.ManufacturerService;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.converter.impl.ManufacturerImportConverter;
import by.baranavichy.backtrucks.importing.model.ManufacturerImportTO;
import by.baranavichy.backtrucks.importing.model.column.ManufacturerColumn;
import by.baranavichy.backtrucks.importing.parser.ImportParser;
import by.baranavichy.backtrucks.importing.parser.ManufacturerParser;
import by.baranavichy.backtrucks.importing.service.ManufacturerImportService;
import by.baranavichy.backtrucks.persistence.repository.CountryRepository;
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
    private final CountryRepository countryRepository;
    private final ManufacturerImportConverter manufacturerImportConverter;
    private final CountryConverter countryConverter;

    @Override
    protected ImportParser<ManufacturerImportTO, ManufacturerColumn> getParser() {
        return this.manufacturerParser;
    }

    @Override
    protected EntityService<ManufacturerTO, ?> getEntityService() {
        return this.manufacturerService;
    }

    @Override
    protected ImportConverter<ManufacturerTO, ManufacturerImportTO> getImportConverter() {
        return this.manufacturerImportConverter;
    }

}
