package by.baranavichy.backtrucks.common.service.impl;

import by.baranavichy.backtrucks.common.converter.EntityTOConverter;
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

    public EngineServiceImpl(EntityTOConverter<Engine, EngineTO> converter, EngineRepository engineRepository) {
        super(converter, engineRepository);
        this.engineRepository = engineRepository;

    }

    @Override
    protected Optional<Engine> getExistingEntity(Engine entityToSave) {
        return engineRepository.findByName(entityToSave.getName());
    }
}
