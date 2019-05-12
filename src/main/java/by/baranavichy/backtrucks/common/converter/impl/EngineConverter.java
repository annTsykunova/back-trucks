package by.baranavichy.backtrucks.common.converter.impl;

import by.baranavichy.backtrucks.common.converter.EntityTOConverter;
import by.baranavichy.backtrucks.common.model.to.EngineTO;
import by.baranavichy.backtrucks.persistence.model.Engine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 29.04.2019.
 */

@Component
@RequiredArgsConstructor
public class EngineConverter implements EntityTOConverter<Engine, EngineTO> {

    private final ManufacturerConverter manufacturerConverter;

    @Override
    public Engine convertToEntity(EngineTO to) {
        Engine engine = new Engine();
        engine.setId(to.getId());
        engine.setName(to.getName());
        engine.setDisplacement(to.getDisplacement());

        if (to.getManufacturer() != null) {
            engine.setManufacturer(manufacturerConverter.convertToEntity(to.getManufacturer()));
        }

        return engine;
    }

    @Override
    public EngineTO convertToTO(Engine entity) {
        EngineTO engineTO = new EngineTO();
        engineTO.setId(entity.getId());
        engineTO.setName(entity.getName());
        engineTO.setDisplacement(entity.getDisplacement());
        if (entity.getManufacturer() != null) {
            engineTO.setManufacturer(manufacturerConverter.convertToTO(entity.getManufacturer()));
        }
        return engineTO;
    }
}
