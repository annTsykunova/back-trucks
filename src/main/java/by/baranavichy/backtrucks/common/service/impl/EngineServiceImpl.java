package by.baranavichy.backtrucks.common.service.impl;

import by.baranavichy.backtrucks.common.converter.impl.EngineConverter;
import by.baranavichy.backtrucks.common.enricher.impl.EngineFetcher;
import by.baranavichy.backtrucks.common.model.to.EngineTO;
import by.baranavichy.backtrucks.common.service.EngineService;
import by.baranavichy.backtrucks.common.service.EntityServiceImpl;
import by.baranavichy.backtrucks.persistence.model.Engine;
import by.baranavichy.backtrucks.persistence.repository.EngineRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Vanya on 29.04.2019.
 */

@Service
public class EngineServiceImpl
        extends EntityServiceImpl<Engine, EngineTO, Long>
        implements EngineService {

    private final EngineRepository engineRepository;

    public EngineServiceImpl(EngineConverter engineConverter, EngineRepository engineRepository,
                             EngineFetcher engineEnricher) {
        super(engineConverter, engineRepository, engineEnricher);
        this.engineRepository = engineRepository;
    }

    @Override
    protected Optional<Long> getExistingEntityId(Engine entityToSave) {
        return engineRepository.findByNameIgnoreCase(entityToSave.getName())
                .map(Engine::getId);
    }

}
