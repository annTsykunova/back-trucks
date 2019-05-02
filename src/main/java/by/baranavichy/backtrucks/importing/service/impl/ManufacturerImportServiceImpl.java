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
import by.baranavichy.backtrucks.persistence.model.Country;
import by.baranavichy.backtrucks.persistence.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Vanya on 27.04.2019.
 */

@Service
public class ManufacturerImportServiceImpl
        extends ImportServiceImpl<ManufacturerTO, ManufacturerImportTO>
        implements ManufacturerImportService {

    private final ManufacturerParser manufacturerParser;
    private final ManufacturerService manufacturerService;
    private final CountryRepository countryRepository;
    private final ManufacturerImportConverter manufacturerImportConverter;

    public ManufacturerImportServiceImpl(ManufacturerParser manufacturerParser, ManufacturerService manufacturerService,
                                         CountryRepository countryRepository,
                                         ManufacturerImportConverter manufacturerImportConverter) {
        this.manufacturerParser = manufacturerParser;
        this.manufacturerService = manufacturerService;
        this.countryRepository = countryRepository;
        this.manufacturerImportConverter = manufacturerImportConverter;
    }

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

    @Override
    protected ManufacturerTO getEnrichedTO(ManufacturerTO toToEnrich) {
        String countryCode = toToEnrich.getCountryTO().getCode();
        if (countryCode != null) {
            Optional<Country> maybeCountry = countryRepository.findByCodeIgnoreCase(countryCode);
        }
        return null;
    }


}
