package by.baranavichy.backtrucks.common.service.impl;

import by.baranavichy.backtrucks.common.converter.impl.ModelConverter;
import by.baranavichy.backtrucks.common.enricher.impl.ModelEnricher;
import by.baranavichy.backtrucks.common.model.to.ModelTO;
import by.baranavichy.backtrucks.common.service.EntityServiceImpl;
import by.baranavichy.backtrucks.common.service.ModelService;
import by.baranavichy.backtrucks.persistence.model.Model;
import by.baranavichy.backtrucks.persistence.repository.ModelRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Vanya on 05.05.2019.
 */

@Service
public class ModelServiceImpl
        extends EntityServiceImpl<Model, ModelTO, Long>
        implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(ModelConverter modelConverter, ModelRepository modelRepository,
                            ModelEnricher modelEnricher) {
        super(modelConverter, modelRepository, modelEnricher);
        this.modelRepository = modelRepository;
    }

    @Override
    protected Optional<Model> getExistingEntity(Model entityToSave) {
        return modelRepository.findByNameIgnoreCase(entityToSave.getName());
    }

}
