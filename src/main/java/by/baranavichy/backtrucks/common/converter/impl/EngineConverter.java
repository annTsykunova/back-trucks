package by.baranavichy.backtrucks.common.converter.impl;

import by.baranavichy.backtrucks.common.converter.EntityTOConverter;
import by.baranavichy.backtrucks.common.model.to.EngineTO;
import by.baranavichy.backtrucks.persistence.model.Engine;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 29.04.2019.
 */

@Component
public class EngineConverter implements EntityTOConverter<Engine, EngineTO> {

    @Override
    public Engine convertToEntity(EngineTO to) {
        Engine engine = new Engine();
        engine.setName(to.getName());
        engine.setDisplacement(to.getDisplacement());
        return engine;
    }

    @Override
    public EngineTO convertToTO(Engine entity) {
        EngineTO engineTO = new EngineTO();
        engineTO.setName(entity.getName());
        engineTO.setDisplacement(entity.getDisplacement());
        return null;
    }
}
