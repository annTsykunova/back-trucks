package by.baranavichy.backtrucks.common.service.impl;

import by.baranavichy.backtrucks.common.converter.impl.EngineConverter;
import by.baranavichy.backtrucks.common.model.to.EngineTO;
import by.baranavichy.backtrucks.common.service.EngineService;
import by.baranavichy.backtrucks.common.service.EntityServiceImpl;
import by.baranavichy.backtrucks.persistence.model.Engine;
import by.baranavichy.backtrucks.persistence.model.Manufacturer;
import by.baranavichy.backtrucks.persistence.repository.EngineRepository;
import by.baranavichy.backtrucks.persistence.repository.ManufacturerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Vanya on 29.04.2019.
 */

@Service
public class EngineServiceImpl
        extends EntityServiceImpl<Engine, EngineTO, Long>
        implements EngineService {

    private final EngineConverter engineConverter;
    private final EngineRepository engineRepository;
    private final ManufacturerRepository manufacturerRepository;

    public EngineServiceImpl(EngineConverter engineConverter, EngineRepository engineRepository, ManufacturerRepository manufacturerRepository) {
        super(engineConverter, engineRepository);
        this.engineConverter = engineConverter;
        this.engineRepository = engineRepository;
        this.manufacturerRepository = manufacturerRepository;
    }


    @Override
    protected Optional<Engine> getExistingEntity(Engine entityToSave) {
        return engineRepository.findByNameIgnoreCase(entityToSave.getName());
    }

    @Override
    protected Engine convertToEntity(EngineTO toToSave) {
        Engine engine = engineConverter.convertToEntity(toToSave);

        Optional<Manufacturer> maybeManufacturer =
                manufacturerRepository.findByNameIgnoreCase(toToSave.getManufacturer().getName());
        maybeManufacturer.ifPresent(engine::setManufacturer);
        return engine;
    }

}
