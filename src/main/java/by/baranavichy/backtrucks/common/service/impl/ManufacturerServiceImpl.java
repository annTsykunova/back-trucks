package by.baranavichy.backtrucks.common.service.impl;

import by.baranavichy.backtrucks.common.converter.impl.CountryConverter;
import by.baranavichy.backtrucks.common.converter.impl.ManufacturerConverter;
import by.baranavichy.backtrucks.common.model.to.ManufacturerTO;
import by.baranavichy.backtrucks.common.service.CountryService;
import by.baranavichy.backtrucks.common.service.EntityServiceImpl;
import by.baranavichy.backtrucks.common.service.ManufacturerService;
import by.baranavichy.backtrucks.persistence.model.Country;
import by.baranavichy.backtrucks.persistence.model.Manufacturer;
import by.baranavichy.backtrucks.persistence.repository.CountryRepository;
import by.baranavichy.backtrucks.persistence.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by Vanya on 27.04.2019.
 */

@Service
public class ManufacturerServiceImpl
        extends EntityServiceImpl<Manufacturer, ManufacturerTO, Long>
        implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;
    private final CountryRepository countryRepository;
    private final ManufacturerConverter manufacturerConverter;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, CountryRepository countryRepository, CountryService countryService, ManufacturerConverter manufacturerConverter, CountryConverter countryConverter) {
        super(manufacturerConverter, manufacturerRepository);
        this.manufacturerRepository = manufacturerRepository;
        this.countryRepository = countryRepository;
        this.manufacturerConverter = manufacturerConverter;
    }

    @Override
    @Transactional
    protected Manufacturer convertToEntity(ManufacturerTO toToSave) {
        Manufacturer manufacturer = manufacturerConverter.convertToEntity(toToSave);

        Optional<Country> maybeCountry = countryRepository.findByCodeIgnoreCase(toToSave.getCountry().getCode());
        maybeCountry.ifPresent(manufacturer::setCountry);
        return manufacturer;
    }

    @Override
    protected Optional<Manufacturer> getExistingEntity(Manufacturer entityToSave) {
        return manufacturerRepository.findByNameIgnoreCase(entityToSave.getName());
    }

}
