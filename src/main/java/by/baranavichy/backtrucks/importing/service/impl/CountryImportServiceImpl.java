package by.baranavichy.backtrucks.importing.service.impl;

import by.baranavichy.backtrucks.common.model.to.CountryTO;
import by.baranavichy.backtrucks.common.service.CountryService;
import by.baranavichy.backtrucks.common.service.EntityService;
import by.baranavichy.backtrucks.importing.converter.CountryImportConverter;
import by.baranavichy.backtrucks.importing.converter.ImportConverter;
import by.baranavichy.backtrucks.importing.model.CountryImportTO;
import by.baranavichy.backtrucks.importing.parser.CountryImportParser;
import by.baranavichy.backtrucks.importing.parser.ImportParser;
import by.baranavichy.backtrucks.importing.service.CountryImportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Created by Vanya on 28.04.2019.
 */

@Service
@RequiredArgsConstructor
public class CountryImportServiceImpl
        extends ImportServiceImpl<CountryTO, CountryImportTO>
        implements CountryImportService {

    private final CountryImportParser countryImportParser;
    private final CountryService countryService;
    private final CountryImportConverter countryImportConverter;

    @Override
    protected ImportParser<CountryImportTO> getParser() {
        return this.countryImportParser;
    }

    @Override
    protected EntityService<CountryTO> getEntityService() {
        return this.countryService;
    }

    @Override
    protected ImportConverter<CountryTO, CountryImportTO> getImportConverter() {
        return this.countryImportConverter;
    }

    @Override
    protected CountryTO getEnrichedTO(CountryTO toToEnrich) {
        return toToEnrich;
    }
}
