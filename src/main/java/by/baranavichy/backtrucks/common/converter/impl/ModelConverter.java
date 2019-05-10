package by.baranavichy.backtrucks.common.converter.impl;

import by.baranavichy.backtrucks.common.converter.EntityTOConverter;
import by.baranavichy.backtrucks.common.model.to.ModelTO;
import by.baranavichy.backtrucks.persistence.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by Vanya on 05.05.2019.
 */

@Component
@RequiredArgsConstructor
public class ModelConverter implements EntityTOConverter<Model, ModelTO> {

    private final ManufacturerConverter manufacturerConverter;
    private final EngineConverter engineConverter;

    @Override
    public Model convertToEntity(ModelTO to) {
        Model model = new Model();
        model.setId(to.getId());
        model.setName(to.getName());
        model.setProductionDateStart(to.getProductionDateStart());
        model.setProductionDateEnd(to.getProductionDateEnd());

        if (to.getManufacturer() != null) {
            model.setManufacturer(manufacturerConverter.convertToEntity(to.getManufacturer()));
        }
        if (to.getEnginesCopy() != null) {
            to.getEnginesCopy().stream()
                    .map(engineConverter::convertToEntity)
                    .forEach(model::addEngine);
        }
        return model;
    }

    @Override
    public ModelTO convertToTO(Model entity) {
        ModelTO model = new ModelTO();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setProductionDateStart(entity.getProductionDateStart());
        model.setProductionDateEnd(entity.getProductionDateEnd());

        if (entity.getManufacturer() != null) {
            model.setManufacturer(manufacturerConverter.convertToTO(entity.getManufacturer()));
        }
        if (entity.getEnginesCopy() != null) {
            entity.getEnginesCopy().stream()
                    .map(engineConverter::convertToTO)
                    .forEach(model::addEngine);
        }

        return model;
    }
}
